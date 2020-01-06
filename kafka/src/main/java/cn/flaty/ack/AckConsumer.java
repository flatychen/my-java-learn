package cn.flaty.ack;

import cn.flaty.KafkaProperties;
import cn.hutool.core.thread.ThreadFactoryBuilder;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.*;
import org.apache.kafka.common.TopicPartition;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Collection;
import java.util.Properties;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author flaty
 * @date 2019-12-26
 */

@Slf4j
public class AckConsumer extends KafkaProperties {


    private String topic = "topic1";


    private static int threads = 2;


    public static void main(String[] args) throws IOException {
        new AckConsumer().start();
        System.in.read();
    }


    private void start() {
        ExecutorService es = Executors.newFixedThreadPool(threads, ThreadFactoryBuilder.create().setNamePrefix("consume-").build());
        for (int i = 0; i < threads; i++) {
            es.execute(new OneConsumer());
        }

    }

    public class OneConsumer implements Runnable {
        @Override
        public void run() {
            Properties properties = consumerProperties();
            properties.put(ConsumerConfig.GROUP_ID_CONFIG, "ConsumerManualCommit");
            KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
            consumer.partitionsFor(topic).stream().forEach(partitionInfo -> log.info("partitionInfo:[{}]", partitionInfo.toString()));
            consumer.subscribe(Arrays.asList(topic), new ConsumerRebalanceListener() {
                @Override
                public void onPartitionsRevoked(Collection<TopicPartition> partitions) {

                }

                @Override
                public void onPartitionsAssigned(Collection<TopicPartition> partitions) {

                }
            });
            while (true) {
                ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(500));
                for (ConsumerRecord<String, String> record : records) {
                    log.info(" #### partition:[{}] offset:[{}] record key:[{}] value:[{}]", record.partition(), record.offset(), record.key(), record.value());
                }
            }
        }
    }


}


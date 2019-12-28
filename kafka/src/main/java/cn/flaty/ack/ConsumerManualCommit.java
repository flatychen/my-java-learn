package cn.flaty.ack;

import cn.flaty.KafkaProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.apache.kafka.common.PartitionInfo;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

/**
 * @author flaty
 * @date 2019-12-26
 */

@Slf4j
public class ConsumerManualCommit extends KafkaProperties {


    private String topic = "topic1";

    public static void main(String[] args) throws IOException {
        new ConsumerManualCommit().start();
        System.in.read();
    }


    public void start() {
        Properties properties = super.consumerProperties();
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "ConsumerManualCommit");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
        List<PartitionInfo> partitionInfos = consumer.partitionsFor(topic);
        partitionInfos.stream().forEach(partitionInfo -> log.info("partitionInfo:[{}]",partitionInfo.toString()));
        consumer.subscribe(Arrays.asList(topic));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(500));
            for (ConsumerRecord<String, String> record : records) {
                log.info(" #### partition:[{}] offset:[{}] record key:[{}] value:[{}]",record.partition(), record.offset(),record.key(),record.value());
            }
        }

    }

}


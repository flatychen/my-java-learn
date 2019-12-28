package cn.flaty.simple;

import cn.flaty.KafkaProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.Properties;

/**
 * @author flaty
 * @date 2019-12-26
 */

@Slf4j
public class SimpleConsumer extends KafkaProperties {


    private String topic = "topic1";

    public static void main(String[] args) throws IOException {
        new SimpleConsumer().start();
        System.in.read();
    }


    public void start() {
        Properties properties = super.consumerProperties();
        properties.put(ConsumerConfig.GROUP_ID_CONFIG, "SimpleConsumer");
        KafkaConsumer<String, String> consumer = new KafkaConsumer<String, String>(properties);
        consumer.subscribe(Arrays.asList(topic));
        while (true) {
            ConsumerRecords<String, String> records = consumer.poll(Duration.ofMillis(500));
            for (ConsumerRecord<String, String> record : records) {
                log.info("record key:[{}] value:[{}]",record.key(),record.value());
            }
        }

    }

}


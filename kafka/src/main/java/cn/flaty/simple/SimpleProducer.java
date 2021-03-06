package cn.flaty.simple;

import cn.flaty.KafkaProperties;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.PartitionInfo;

import java.io.IOException;
import java.util.List;
import java.util.Properties;

/**
 * @author flaty
 * @date 2019-12-26
 */

@Slf4j
public class SimpleProducer extends KafkaProperties {


    private String topic = "topic1";

    public static void main(String[] args) throws IOException {
        new SimpleProducer().start();
        System.in.read();
    }


    public void start() {
        Properties properties = super.producerProperties();
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
        List<PartitionInfo> partitionInfos = producer.partitionsFor(topic);
        log.info("partitionInfos:[{}]",partitionInfos);
        producer.send(new ProducerRecord<>(topic, "key", "value"), (metadata, exception) -> {
            log.info("metadata:[{}]",metadata);
        });
    }

}


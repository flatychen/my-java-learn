package cn.flaty.multi;

import cn.flaty.KafkaProperties;
import cn.hutool.core.thread.ThreadUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.PartitionInfo;

import java.io.IOException;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

/**
 * @author flaty
 * @date 2019-12-26
 */

@Slf4j
public class MultiProducerMsg extends KafkaProperties {


    private String topic = "topic1";

    public static void main(String[] args) throws IOException {
        new MultiProducerMsg().start();
        System.in.read();
    }


    public void start() {
        Properties properties = super.producerProperties();
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);
        List<PartitionInfo> partitionInfos = producer.partitionsFor(topic);
        log.info("partitionInfos:[{}]", partitionInfos);
        while (true) {
            ThreadUtil.sleep(1, TimeUnit.SECONDS);
            ProducerRecord producerRecord = new ProducerRecord<>(topic, "key:" + System.currentTimeMillis(), "value:" + System.currentTimeMillis());
            producer.send(producerRecord, (metadata, exception) -> {
                // 更新状态。确保发送成功
                log.info("metadata partition:[{}]  offset:[{}]", metadata.partition(),metadata.offset(),metadata);
            });
        }
    }
}




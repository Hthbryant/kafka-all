package com.lingyi;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;
import org.apache.kafka.common.serialization.StringSerializer;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

/**
 * @author 咕噜科
 * ClassName: MyProducer
 * date: 2023-06-13 0:22
 * Description:
 * version 1.0
 */
@Slf4j
public class MyProducer {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Properties properties = new Properties();
        properties.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG,"192.168.1.105:9092,192.168.1.105:9093,192.168.1.105:9094");
        properties.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        properties.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG,StringSerializer.class);

        MyProduct myProduct = new MyProduct(1000,"测试名称");

        KafkaProducer<String,String> kafkaProducer = new KafkaProducer<>(properties);
        ProducerRecord<String,String> record = new ProducerRecord(
                "topic3",
                0,
                "producer",
                JSON.toJSONString(myProduct)
        );
        RecordMetadata metadata = kafkaProducer.send(record).get();
        log.info("主题：{}",metadata.topic());
        log.info("分区：{}",metadata.partition());
        log.info("偏移量：{}",metadata.offset());
    }

}

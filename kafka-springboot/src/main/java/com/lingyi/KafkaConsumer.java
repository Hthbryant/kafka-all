package com.lingyi;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.stereotype.Component;

/**
 * @author 咕噜科
 * ClassName: KafkaConsumer
 * date: 2023-06-17 0:36
 * Description:
 * version 1.0
 */
@Component
@Slf4j
public class KafkaConsumer {

    @KafkaListener(topics = "topic3",groupId = "es55")
    public void onMessage(ConsumerRecord<String,String> record, Acknowledgment ack) {
        log.info("收到消息！");
        log.info("主题:{}",record.topic());
        log.info("数据:{}",record.value());
        log.info("分区:{}",record.partition());
        log.info("偏移量:{}",record.offset());

    }

}

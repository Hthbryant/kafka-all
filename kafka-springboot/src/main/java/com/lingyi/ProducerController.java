package com.lingyi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 咕噜科
 * ClassName: Procucer
 * date: 2023-06-17 0:00
 * Description:
 * version 1.0
 */
@RestController
@RequestMapping("/producer")
public class ProducerController {

    @Autowired
    KafkaTemplate<String,String> kafkaTemplate;

    @RequestMapping("/send/{msg}")
    public String send(@PathVariable(value = "msg")String msg){
        kafkaTemplate.send("topic3",msg);
        return "success";
    }
}

package com.lingyi.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 咕噜科
 * ClassName: biz.KafkaSpringApplication
 * date: 2023-06-16 23:59
 * Description:
 * version 1.0
 */
@SpringBootApplication
@ComponentScan(basePackages = "com.lingyi")
public class KafkaSpringApplication {

    public static void main(String[] args) {
        SpringApplication.run(KafkaSpringApplication.class,args);
    }

}

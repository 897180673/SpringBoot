package com.example.demo.mq;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;

import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Component
@Slf4j
public class RabbitProducter {
    @Resource
    RabbitTemplate rabbitTemplate;

    public void sendMessage(String message){
        if(rabbitTemplate==null){
            log.info("testKey是null");
        }
        rabbitTemplate.convertAndSend("testKey",message);
    }

}
package com.example.demo.mq;


import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RabbitConsumer {

    @RabbitListener(queues = "testKey")
    public void consumerMessage(String message){

            log.info("消费到的消息为:"+message);
    }

}

package com.example.demo.scheduling;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Slf4j
public class TestScheduling {

    @Scheduled(fixedDelay = 1000)
    public void testScheduling(){
        System.out.println(new Date());
        log.info(new Date()+"#");
    }

}

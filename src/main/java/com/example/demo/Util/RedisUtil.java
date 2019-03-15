package com.example.demo.Util;


import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class RedisUtil {

    @Resource
    private StringRedisTemplate stringRedisTemplate;


    public  void set(String key,String value){
        stringRedisTemplate.opsForValue().set(key,value);
    }

}

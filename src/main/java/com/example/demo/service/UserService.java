package com.example.demo.service;

import com.example.demo.dao.UserMapper;
import com.example.demo.domain.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserService {
    @Resource
    private UserMapper userMapper;


    public String sayHello() {
        return "hello world";
    }

    public User getUserById(String userId) throws Exception{
        return userMapper.getUserByName(userId);
    }

}

package com.example.demo.controller;


import com.example.demo.Util.RedisUtil;
import com.example.demo.domain.User;
import com.example.demo.mq.RabbitProducter;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class UserController {
    @Resource
    private UserService userService;
    @Resource
    private RedisUtil redisUtil;

    @Resource
    RabbitProducter rabbitProducter;


    @GetMapping("/test")
    public String test(){
        redisUtil.set("你好","hello你好");
        String result=userService.sayHello();
        return result;
    }


    @GetMapping("/getUserId")
    public User getUserByName(HttpServletRequest request){
        String userId=request.getParameter("userId");
        User user=null;
        try {
              user=userService.getUserById(userId);
        } catch (Exception e) {
            log.error(e.toString());
        }
        return  user;
    }


    private List<User> userlist=new ArrayList<>();

    //堆区内存溢出
    @GetMapping("/heapOver")
    public void heapOverTest(){
        while(true){
            userlist.add(new User());
        }
    }


    //cpu飙高测试
    @GetMapping("letCpuBusy")
    public void letCpuBusy(){
        int i=0;
        while(true) {
            i++;
        }

    }



    @GetMapping("/testMq")
    public void testMq(String message){

        rabbitProducter.sendMessage(message);
    }



}

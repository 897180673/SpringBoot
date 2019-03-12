package com.example.demo.controller;


import com.example.demo.domain.User;
import com.example.demo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@RestController
@Slf4j
public class UserController {
    @Resource
    private UserService userService;

    @GetMapping("/test")
    public String test(){
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

}

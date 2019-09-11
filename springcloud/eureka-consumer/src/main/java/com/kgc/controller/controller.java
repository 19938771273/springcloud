package com.kgc.controller;

import com.kgc.controller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class controller {
    @Autowired
    UserService userService;
    @RequestMapping("/user")
    public String getUserName(){
       String username =  userService.getUserName();
        System.out.println(username+"*********");
       return username;
    }
}

package com.kgc.feignclient.controller;

import com.kgc.feignclient.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    userService uservice;
    @RequestMapping("/list")
    public String getUserName() {
        String name = uservice.getUsername();
        System.out.println("feignclient"+" "+name);
        return name;
    }
}

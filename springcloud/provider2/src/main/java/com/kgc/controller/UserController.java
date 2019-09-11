package com.kgc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @RequestMapping("/list")

    public String getUserName(){

        System.out.println("这里是服务提供者2");
        return "success";
    }

}

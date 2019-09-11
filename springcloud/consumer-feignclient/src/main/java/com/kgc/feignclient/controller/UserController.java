package com.kgc.feignclient.controller;

import com.kgc.feignclient.entity.User;
import com.kgc.feignclient.service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    userService uservice;
    @RequestMapping("/sava")
    public int saveUser(@RequestParam  Map<String,Object> map) {
       int issuccess = uservice.saveUser(map);
        System.out.println("feignclient"+" ");
        return issuccess;
    }
    @RequestMapping("/query/{id}")
    public List<User> queryUser(@PathVariable("id") int id){
        List<User> users = uservice.queryUserById(id);
        return users;

    }
}

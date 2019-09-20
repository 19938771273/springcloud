package com.kgc.controller;

import com.kgc.entity.User;
import com.kgc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
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
    UserService uservice;
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

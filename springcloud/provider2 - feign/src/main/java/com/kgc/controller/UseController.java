package com.kgc.controller;

import com.kgc.Service.UserService;
import com.kgc.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class UseController {
    @Autowired
    UserService userService;
    /**
     * 保存user对象
     * @param userMap
     * @return int是否保存成功
     */
    @PostMapping
    public int saveUser(@RequestBody Map<String,Object> userMap){
        System.out.println(userMap.get("id"));
        int success = userService.saveUser(userMap);
        return success;
    }
    @GetMapping("{id}")
    public List<User> queryUserById(@PathVariable("id") int id){
       List<User> list = userService.queryUserById(id);
       return list;
    }


}

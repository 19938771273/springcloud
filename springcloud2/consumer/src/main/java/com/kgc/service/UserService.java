package com.kgc.service;

import com.kgc.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//@FeignClient(value = "eureka-provider")调用的服务微服务名称 fallback 调用的服务失败是，执行该类的实现方法
@FeignClient(value = "provider1",fallback = UserServiceHyStrix.class,path = "/users")
public interface UserService {
    @PostMapping
    public int saveUser(@RequestBody Map<String, Object> userMap);
    @GetMapping("/{id}")
    public List<User> queryUserById(@PathVariable("id") int id);
}
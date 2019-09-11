package com.kgc.feignclient.service;

import com.kgc.feignclient.entity.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

//@FeignClient(value = "eureka-provider")调用的服务微服务名称
@FeignClient(value = "provider-feign")
@RequestMapping("/users")
public interface userService {
    @PostMapping
    public int saveUser(@RequestBody Map<String,Object> userMap);
    @GetMapping("/{id}")
    public List<User> queryUserById(@PathVariable("id") int id);
}
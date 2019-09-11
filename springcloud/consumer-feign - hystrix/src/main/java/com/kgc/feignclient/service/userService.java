package com.kgc.feignclient.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
//@FeignClient(value = "eureka-provider")调用的服务微服务名称
@FeignClient(value = "eureka-provider")
public interface userService {
    @RequestMapping("/user/list")
    String getUsername();
}
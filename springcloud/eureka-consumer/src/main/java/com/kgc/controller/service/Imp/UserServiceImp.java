package com.kgc.controller.service.Imp;

import com.kgc.controller.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.transform.Templates;
@Service
public class UserServiceImp implements UserService {
    @Autowired
    RestTemplate restTemplate;//访问服务提供者
    public String getUserName() {
        System.out.println("*****************************");
        return restTemplate.getForObject("http://eureka-provider/user/list",String.class);
    }
}

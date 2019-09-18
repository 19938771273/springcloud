package com.kgc.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @GetMapping("/user")
    public String normal( ) {
        return "用户页面";
    }

    @GetMapping("/show")
    public String medium() {
        return "这也是用户页面";
    }

    @GetMapping("/admin")
    public String admin() {
        return "管理员页面";
    }

}

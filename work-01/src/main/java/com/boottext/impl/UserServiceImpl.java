package com.boottext.impl;

import com.boottext.entity.User;
import com.boottext.mapper.UserDao;
import com.boottext.service.UserDaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl {
    @Autowired
    private UserDao dao;


    public void insert(User s){
        Integer insert = this.dao.insert(s);
    }
}

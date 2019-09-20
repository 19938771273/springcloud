package com.kgc.service;

import com.kgc.entity.User;

import java.util.List;
import java.util.Map;

public interface UserService {
    public int saveUser(Map<String, Object> userMap);
    public List<User> queryUserById(int id);
}

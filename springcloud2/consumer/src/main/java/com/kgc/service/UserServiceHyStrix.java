package com.kgc.service;
import com.kgc.entity.User;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 断路器
 */
@Component
public class UserServiceHyStrix implements UserService {
    public int saveUser(Map<String, Object> userMap) {
        return -1;
    }

    public List<User> queryUserById(int id) {
        List<User> result = new ArrayList<User>();
        User user = new User();
        user.setId(0);
        user.setUsername("用户服务不可用");
        user.setPassword("0");
        result.add(user);
        return result;
    }
}

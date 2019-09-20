package com.kgc.service.Imp;

import com.kgc.entity.User;
import com.kgc.service.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImp implements UserService {
    public int saveUser(Map<String, Object> userMap) {
        int id =  Integer.parseInt((String)userMap.get("id")) ;
        String username = (String)userMap.get("username");
        String password = (String)userMap.get("password");
        System.out.println(id+" "+username+" "+password);
        if (id==1){
            return 1;
        }
        return 0;
    }

    public List<User> queryUserById(int id) {
        List<User> users = new ArrayList<User>();
        User u = new User();
        u.setId(1);
        u.setPassword("123");
        u.setUsername("lisi");
        User u1 = new User();
        u1.setId(2);
        u1.setPassword("1234");
        u1.setUsername("zhangsan");
        users.add(u);
        users.add(u1);
        return users;
    }
}

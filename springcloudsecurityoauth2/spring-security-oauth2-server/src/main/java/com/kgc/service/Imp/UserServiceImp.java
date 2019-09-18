package com.kgc.service.Imp;

import com.kgc.entity.TbPermission;
import com.kgc.entity.TbUser;
import com.kgc.mapper.UserMapper;
import com.kgc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserServiceImp<UserMapperMapper> implements UserService {
    @Autowired
    private UserMapper usermapper;
    @Override
    public TbUser getUserByuserName(String userName) {
        TbUser user = usermapper.getUserByUserName(userName);
        System.out.println(user.getUserName());
        return user;
    }

    @Override
    public List<TbPermission> getTbpermissionByuserName(int userId) {
       List<TbPermission> permissions = usermapper.getPermissionByUserId(userId);
       permissions.forEach(p -> System.out.println(
               p.getName()+"" +p.getValue()
       ));
       return permissions;
    }
}

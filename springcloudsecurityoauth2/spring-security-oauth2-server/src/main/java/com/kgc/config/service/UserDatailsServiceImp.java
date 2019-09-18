package com.kgc.config.service;

import com.kgc.entity.TbPermission;
import com.kgc.entity.TbUser;
import com.kgc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 自定义认证配置
 */
@Service
public class UserDatailsServiceImp implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //获取数据库中的user
        TbUser user = userService.getUserByuserName(username);
        System.out.println(user.getUserName()+"***********************************");
        //创建集合存储权限GrantedAuthority权限
        List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
        //判断用户是否存在，
        if(user!=null){
            //更具用户id查取权限
            List<TbPermission> listTbpermission = userService.getTbpermissionByuserName(user.getId());
            System.out.println(listTbpermission+"-------------------------------------------------");
            //遍历集合
            listTbpermission.forEach(permission ->{

                //获取权限对象
               GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(permission.getValue());
               //将权限存放在集合
               grantedAuthorities.add(grantedAuthority);
                    } );


        }
        return new User(user.getUserName(),user.getPassWord(),grantedAuthorities);
    }
}

package com.boottext.realm;

import com.boottext.entity.Student;
import com.boottext.service.StudentDaoService;
import org.apache.catalina.security.SecurityUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;
import java.util.Set;

public class MyRealm extends AuthorizingRealm {

    @Autowired
    private StudentDaoService service;

    /**
     * 授权
     *
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //从token中取出用户名  token来自controller层
        String studentUser = (String) token.getPrincipal();
        //根据用户输入的studentUser从数据库查询 得到一条学生对象的数据 里面有名字 密码 年龄
        Student user = service.findByUsername(studentUser);

        //根据当前登录人名查询到用户名
        if (user == null) {
            throw new UnknownAccountException("用户名不存在");
        }
        //从学生对象的数据里拿到密码
        String password = user.getPassword();

        AuthenticationInfo info = new SimpleAuthenticationInfo(user,password,this.getName());
        System.out.println("realm"+info);
        return info;
    }

    /**
     * 认证
     *
     * @param
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection pl) {
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        Subject subject = SecurityUtils.getSubject();
        //获取登录人信息存入对象
        Student principal = (Student)subject.getPrincipal();
        // 获得对象的id  根据id查询到一条数据
        Student per = service.findById(principal.getId());
        //把这条数据的权限参数存入info
        info.addStringPermission(per.getPerms());
        return info;
    }
}

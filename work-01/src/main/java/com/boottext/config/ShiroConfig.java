package com.boottext.config;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import com.boottext.realm.MyRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shirFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        // 必须设置 SecurityManager
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        // setLoginUrl 如果不设置值，默认会自动寻找Web工程根目录下的"/login.jsp"页面 或 "/login" 映射
        shiroFilterFactoryBean.setLoginUrl("/show/loginUser");
        // 设置无权限时跳转的 地址;
        shiroFilterFactoryBean.setUnauthorizedUrl("/show/unAuth");
        //访问下面请求都要权限
        Map<String, String> map = new LinkedHashMap<>();
       /* //update需要权限 需要的权限为:teacher:all  如果没有权限那就跳转到unAuth页面
        map.put("/show/update", "authc");
        map.put("/show/update", "perms[teacher:all]");
        map.put("/show/gotoadd", "authc");
        map.put("/show/list", "authc");
        //登出
        // map.put("/show/logout","logout");
        //添加用户需要老师权限
        map.put("/show/add", "perms[teacher:all]");

        //用户，需要角色权限 “user”
        map.put("/user/**", "roles[user]");
        //管理员，需要角色权限 “admin”
        map.put("/admin/**", "roles[admin]");
        //其余接口一律拦截
        //主要这行代码必须放在所有权限设置的最后，不然会导致所有 url 都被拦截*/
        map.put("/show/*", "anon");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(map);
        return shiroFilterFactoryBean;
    }

    /**
     * 注入 securityManager
     */
    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        // 设置realm.
        securityManager.setRealm(myRealm());
        return securityManager;
    }

    /**
     * shiroDialaect   thylemeaf相关shiro
     *
     * @return
     */

    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }

    /**
     * 自定义身份认证 realm;
     * <p>
     * 必须写这个类，并加上 @Bean 注解，目的是注入 CustomRealm，
     * 否则会影响 CustomRealm类 中其他类的依赖注入
     */
    @Bean
    public MyRealm myRealm() {
        return new MyRealm();
    }
}
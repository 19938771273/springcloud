package com.kgc.config;

import com.kgc.config.service.UserDatailsServiceImp;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableWebSecurity//开启security
//表示所有请求都会经过这个拦截器
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)
public class WebSecurityConfiger extends WebSecurityConfigurerAdapter {
    /**
     *
     * @return
     * 获取自定义的UserDetailsService
     */
    @Bean
    public UserDetailsService userDetailsService(){
        return new UserDatailsServiceImp();
    }
    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    /**
     * 需要排除的
     */
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/oauth/check_token");
    }



    public void configure(AuthorizationServerSecurityConfigurer oauthServer) throws Exception {
        //enable client to get the authenticated when using the /oauth/token to get a access token
        //there is a 401 authentication is required if it doesn't allow form authentication for clients when access /oauth/token
        oauthServer.allowFormAuthenticationForClients();
    }

    @Override
    //账号密码认证
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {

//        auth.inMemoryAuthentication().withUser("admin")
//                .password(passwordEncoder().encode("123")).roles("ADMIN");
        //使用数据库的账号认证
        auth.userDetailsService(userDetailsService());
    }
}

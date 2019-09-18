package com.kgc.resourcesConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
@Configuration
@EnableResourceServer
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true,jsr250Enabled = true)
public class ResourcesServerConfig extends ResourceServerConfigurerAdapter {
    @Override
    /**
     * 配置资源访问权限
     */
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/user").hasAnyAuthority("query")
                .antMatchers("/show").hasAnyAuthority("save")
                .antMatchers("/admin").hasAnyAuthority("query");
    }
}

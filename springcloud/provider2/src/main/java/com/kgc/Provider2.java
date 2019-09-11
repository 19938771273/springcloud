package com.kgc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient//表示启用eureka客户端
public class Provider2
{
    public static void main( String[] args )
    {
        SpringApplication.run(Provider2.class,args);
    }
}

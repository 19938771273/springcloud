package com.kgc;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Unit test for simple App.
 */
@SpringBootApplication//这是启动类
@EnableEurekaServer//表示这是一个ErurekaServer
public class EurekaServe1
{
    /**
     * Rigorous Test :-)
     */
    public static void main(String[] args) {
        SpringApplication.run(EurekaServe1.class,args);
    }
}

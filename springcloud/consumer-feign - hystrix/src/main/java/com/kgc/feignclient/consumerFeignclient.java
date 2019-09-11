package com.kgc.feignclient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Hello world!
 *启动类使用feignclient做负载均衡
 */
@SpringBootApplication
@EnableEurekaClient
@EnableDiscoveryClient
@EnableFeignClients// @EnableFeignClients， 表示用于使用 Feign 方式。
public class consumerFeignclient
{
    public static void main(String[] args) {
        SpringApplication.run(consumerFeignclient.class,args);
    }
}

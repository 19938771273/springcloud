package com.kgc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@EnableDiscoveryClient//用于发现eureka 注册中心的微服务。
@EnableEurekaClient//表示这是一个eureka客服端类
public class ConsumerApplication
{
    public static void main( String[] args )
    {
        SpringApplication.run(ConsumerApplication.class,args);
    }

    @Bean
    @LoadBalanced//启动负载均衡
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}

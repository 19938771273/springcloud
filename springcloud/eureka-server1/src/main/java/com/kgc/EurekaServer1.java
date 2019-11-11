package com.kgc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Hello world!
 *
 */
@EnableEurekaServer
@SpringBootApplication
public class EurekaServer1
{
    public static void main( String[] args )
    {
		/**
		ÐÞ¸Ä
		*/

        SpringApplication.run(EurekaServer1.class,args);
    }
}

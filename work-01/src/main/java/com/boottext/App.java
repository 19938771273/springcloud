package com.boottext;

import com.boottext.entity.Student;
import com.boottext.entity.User;
import com.boottext.impl.StudentServiceImpl;
import com.boottext.impl.UserServiceImpl;
import com.boottext.mapper.StudentDao;
import com.boottext.mapper.UserDao;
import com.boottext.service.StudentDaoService;
import com.boottext.service.UserDaoService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import java.util.*;

@SpringBootApplication
@MapperScan({"com.boottext.mapper"})
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(App.class);
        /*
         * 查所有加载在spring的类
         */
       String[] names = run.getBeanDefinitionNames();
        for (String name :names){
            System.out.println(name);
        }

    }

}
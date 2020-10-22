package com.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/*
* 入口类
* */
@SpringBootApplication
//@ComponentScan(com.hello.MygetMethod)
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}

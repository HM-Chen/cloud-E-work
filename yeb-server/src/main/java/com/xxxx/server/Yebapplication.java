package com.xxxx.server;



//import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@Configuration
@MapperScan(basePackages = "com.xxxx.server.mapper")
//@EnableScheduling
public class Yebapplication {
    public static void main(String[] args) {
        SpringApplication.run(Yebapplication.class,args);
    }
}

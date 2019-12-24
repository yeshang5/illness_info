package com.bh.illnessinfo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.bh.illnessinfo")
@EnableAutoConfiguration
public class IllnessInfoApplication {

    public static void main(String[] args) {
        SpringApplication.run(IllnessInfoApplication.class, args);
    }

}

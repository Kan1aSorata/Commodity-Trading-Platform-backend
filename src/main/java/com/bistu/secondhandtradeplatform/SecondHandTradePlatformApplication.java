package com.bistu.secondhandtradeplatform;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan("com.bistu.secondhandtradeplatform.mapper")
public class SecondHandTradePlatformApplication {

    public static void main(String[] args) {
        SpringApplication.run(SecondHandTradePlatformApplication.class, args);
    }

}

package com.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@EnableWebSecurity
@EnableFeignClients
@EnableEurekaClient
@MapperScan(basePackages = "com.provider.dao")
@SpringBootApplication
public class OrangeProviderApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrangeProviderApplication.class, args);
    }

}

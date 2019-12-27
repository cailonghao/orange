package com.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
@MapperScan("com.security.dao")
@EnableWebSecurity
@EnableAuthorizationServer
@EnableDiscoveryClient
@SpringBootApplication
public class OrangeSecurityApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrangeSecurityApplication.class, args);
    }

}

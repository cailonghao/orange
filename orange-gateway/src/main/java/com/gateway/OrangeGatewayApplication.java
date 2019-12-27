package com.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class
OrangeGatewayApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrangeGatewayApplication.class, args);
    }

}

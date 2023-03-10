package com.example.pixgatewayspringcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

//@EnableCircuitBreaker - deprecated!
@EnableDiscoveryClient
@SpringBootApplication
public class PixGatewaySpringcloudApplication {

    public static void main(String[] args) {
        SpringApplication.run(PixGatewaySpringcloudApplication.class, args);
    }

}

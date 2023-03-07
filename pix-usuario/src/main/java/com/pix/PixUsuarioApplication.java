package com.pix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class PixUsuarioApplication {

    public static void main(String[] args) {
        SpringApplication.run(PixUsuarioApplication.class, args);
    }

}

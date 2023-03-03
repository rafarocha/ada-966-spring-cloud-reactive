package com.pix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class PixGatewayZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(PixGatewayZuulApplication.class, args);
    }

}

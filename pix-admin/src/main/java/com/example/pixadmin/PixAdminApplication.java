package com.example.pixadmin;

import de.codecentric.boot.admin.server.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class PixAdminApplication {

    public static void main(String[] args) {
        SpringApplication.run(PixAdminApplication.class, args);
    }

}

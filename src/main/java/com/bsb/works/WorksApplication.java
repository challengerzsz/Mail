package com.bsb.works;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class WorksApplication {

    public static void main(String[] args) {
        SpringApplication.run(WorksApplication.class, args);
    }
}

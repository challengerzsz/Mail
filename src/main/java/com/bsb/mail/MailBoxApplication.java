package com.bsb.mail;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class MailBoxApplication {

    public static void main(String[] args) {
        SpringApplication.run(MailBoxApplication.class, args);
    }
}

package com.example.jeeproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class JeeProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(JeeProjectApplication.class, args);
    }

}

package com.example.lightweight_service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.example"})
@EntityScan("com.example")
public class LightweightServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(LightweightServiceApplication.class, args);
    }

}

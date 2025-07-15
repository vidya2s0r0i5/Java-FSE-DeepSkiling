package com.cognizant.spring_learn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication // This annotation enables auto-configuration, component scanning, and more
public class SpringlearnApplication { // Using the suggested name

    public static void main(String[] args) {
        SpringApplication.run(SpringlearnApplication.class, args);
    }
}

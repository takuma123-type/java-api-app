package com.example.menta_api.cmd;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.example.menta_api")
public class Main {

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}

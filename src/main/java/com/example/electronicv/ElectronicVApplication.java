package com.example.electronicv;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.example")
public class ElectronicVApplication {

    public static void main(String[] args) {
        SpringApplication.run(ElectronicVApplication.class, args);
    }


}

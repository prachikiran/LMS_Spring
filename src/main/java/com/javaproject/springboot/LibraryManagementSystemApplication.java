package com.javaproject.springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class LibraryManagementSystemApplication {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(LibraryManagementSystemApplication.class, args);
    }
}
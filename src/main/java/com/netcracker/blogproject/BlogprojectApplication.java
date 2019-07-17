package com.netcracker.blogproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class BlogprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(BlogprojectApplication.class, args);
    }

}

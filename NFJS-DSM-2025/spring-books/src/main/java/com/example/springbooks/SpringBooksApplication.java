package com.example.springbooks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class SpringBooksApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringBooksApplication.class, args);
  }

}

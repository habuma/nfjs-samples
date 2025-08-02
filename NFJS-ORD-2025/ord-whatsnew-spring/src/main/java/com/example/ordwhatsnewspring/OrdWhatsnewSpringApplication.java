package com.example.ordwhatsnewspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@Import(MyBeanRegistrar.class)
@EnableScheduling
public class OrdWhatsnewSpringApplication {

  public static void main(String[] args) {
    SpringApplication.run(OrdWhatsnewSpringApplication.class, args);
  }

}

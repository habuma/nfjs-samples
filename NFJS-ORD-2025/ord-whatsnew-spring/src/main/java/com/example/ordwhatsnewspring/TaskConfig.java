package com.example.ordwhatsnewspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskDecorator;

@Configuration
public class TaskConfig {

  @Bean
  TaskDecorator taskDecorator() {
    return runnable -> {
      return () -> {
        System.err.println("*** BEFORE");
//        runnable.run();
        System.err.println("*** AFTER\n\n");
      };
    };
  }

}

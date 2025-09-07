package com.example.springbooks;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskDecorator;

@Configuration
public class ScheduledConfig {

  @Bean
  public TaskDecorator taskDecorator() {
    return runnable -> {
      System.err.println("Wrapped in thread: " + Thread.currentThread().getName());
      return () -> {
        System.err.println("Running task in thread: " + Thread.currentThread().getName());
        runnable.run();
        System.err.println("Task finished in thread: " + Thread.currentThread().getName());
      };
    };
  }

}

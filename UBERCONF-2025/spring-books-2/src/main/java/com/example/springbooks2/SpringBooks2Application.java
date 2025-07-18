package com.example.springbooks2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Fallback;
import org.springframework.core.task.TaskDecorator;
import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.config.Task;

@SpringBootApplication
@EnableScheduling
public class SpringBooks2Application {

  public static void main(String[] args) {
    SpringApplication.run(SpringBooks2Application.class, args);
  }

  @Bean
  public TaskDecorator taskDecorator() {
    return runnable -> {
      System.err.println("TaskDecorator: Wrapping runnable");
      return () -> {
        System.err.println("TaskDecorator: Running wrapped runnable");
        runnable.run();
        System.err.println("TaskDecorator: Finished running wrapped runnable");
      };
    };
  }

  @Bean
  @ConditionalOnProperty(name="thing.service.main", havingValue = "true")
  ThingService thingService() {
    return new ThingService("MAIN THING");
  }

  @Bean
  @Fallback
  ThingService thingService2() {
    return new ThingService("FALLBACK THING");
  }

}

package com.example.springbooks;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Fallback;
import org.springframework.context.annotation.Primary;

@Configuration
public class SomeConfig {

  @Bean
  @Fallback
  public SomeService someService() {
    return new SomeService("Doing something important!");
  }

  @Bean
  SomeService someService2() {
    return new SomeService("Doing something else!");
  }

}

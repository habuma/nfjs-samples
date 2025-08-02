package com.example.ordwhatsnewspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SomeComponentConfiguration {

//  @Bean
  SomeComponent someRealComponent() {
    return new SomeComponent("REAL THING");
  }

}

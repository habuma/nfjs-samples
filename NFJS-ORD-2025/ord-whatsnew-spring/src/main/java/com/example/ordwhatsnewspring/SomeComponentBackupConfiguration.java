package com.example.ordwhatsnewspring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Fallback;

@Configuration
public class SomeComponentBackupConfiguration {

  @Bean
  @Fallback
  SomeComponent someBackupComponent() {
    return new SomeComponent("BACKUP THING");
  }

}

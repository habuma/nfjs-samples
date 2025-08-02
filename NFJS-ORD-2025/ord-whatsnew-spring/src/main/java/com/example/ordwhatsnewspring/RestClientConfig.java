package com.example.ordwhatsnewspring;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.service.registry.ImportHttpServices;

@Configuration
@ImportHttpServices(group = "themeparks", basePackageClasses = {ThemeParksApi.class})
public class RestClientConfig {

  @Bean
  ApplicationRunner go(ThemeParksApi themeParksApi) {
    return args -> {
      var destinations = themeParksApi.getDestinations();
      var destinationsList = destinations.destinations();
      destinationsList.forEach(destination -> {
        System.err.println(" - Destination: " + destination.id() + " / " + destination.name());
      });
    };
  }

}

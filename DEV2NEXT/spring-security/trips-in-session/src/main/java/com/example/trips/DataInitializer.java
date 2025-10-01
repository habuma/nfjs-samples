package com.example.trips;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.sql.Date;

@Configuration
public class DataInitializer {

  @Bean
  ApplicationRunner init(TripRepository tripRepository) {
    return args -> {
      tripRepository.save(new Trip(null, "tony", "Paris", "London", Date.valueOf("2024-07-10"), Date.valueOf("2024-07-15")));
      tripRepository.save(new Trip(null, "steve", "New York", "Orlando", Date.valueOf("2024-08-22"), Date.valueOf("2024-08-25")));
      tripRepository.save(new Trip(null, "bruce", "Tokyo", "Shanghai", Date.valueOf("2024-09-12"), Date.valueOf("2024-09-18")));
      tripRepository.save(new Trip(null, "tony", "London", "Oslo", Date.valueOf("2024-10-20"), Date.valueOf("2024-10-25")));
      tripRepository.save(new Trip(null, "thanos", "Sydney", "Mumbai", Date.valueOf("2024-11-15"), Date.valueOf("2024-11-20")));
    };
  }

}

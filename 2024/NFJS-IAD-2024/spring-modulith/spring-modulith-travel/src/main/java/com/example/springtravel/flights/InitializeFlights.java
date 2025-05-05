package com.example.springtravel.flights;

import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalTime;

@Configuration
public class InitializeFlights {
    @Bean
    ApplicationRunner go(FlightRepository flightRepository) {
    return args -> {
      flightRepository.save(new Flight(null, "SA1971", "DEN", "MCO", LocalTime.of(13, 15)));
      flightRepository.save(new Flight(null, "SA1955", "DEN", "SNA", LocalTime.of(18, 30)));
      flightRepository.save(new Flight(null, "SA2024", "DEN", "STL", LocalTime.of(20, 00)));
    };
  }
}

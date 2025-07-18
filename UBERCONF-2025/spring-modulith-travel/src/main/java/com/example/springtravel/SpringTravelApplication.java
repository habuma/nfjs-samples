package com.example.springtravel;

import com.example.springtravel.flights.Flight;
import com.example.springtravel.flights.FlightService;
import com.example.springtravel.flights.internal.FlightRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalTime;

@SpringBootApplication
public class SpringTravelApplication {

  public static void main(String[] args) {
    SpringApplication.run(SpringTravelApplication.class, args);
  }

}

package com.example.springtravel.flights.internal;

import com.example.springtravel.flights.Flight;
import org.springframework.modulith.ApplicationModuleInitializer;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
public class FlightInitializer implements ApplicationModuleInitializer {

  private final FlightRepository flightRepository;

  public FlightInitializer(FlightRepository flightRepository) {
    this.flightRepository = flightRepository;
  }

  @Override
  public void initialize() {
      flightRepository.save(new Flight(null, "SA1971", "DEN", "MCO", LocalTime.of(13, 15)));
      flightRepository.save(new Flight(null, "SA1955", "DEN", "SNA", LocalTime.of(18, 30)));
      flightRepository.save(new Flight(null, "SA2024", "DEN", "STL", LocalTime.of(20, 00)));
  }
}

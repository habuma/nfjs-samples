package com.example.springtravel.flights.internal;

import com.example.springtravel.flights.Flight;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface FlightRepository extends CrudRepository<Flight, Long> {

  Optional<Flight> findByFlightNumber(String flightNumber);

}

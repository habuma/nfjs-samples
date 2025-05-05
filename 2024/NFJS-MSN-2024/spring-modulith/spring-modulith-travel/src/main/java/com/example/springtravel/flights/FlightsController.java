package com.example.springtravel.flights;

import com.example.springtravel.flights.internal.Flight;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flights")
public class FlightsController {

  private final FlightService flightService;

  public FlightsController(FlightService flightService) {
    this.flightService = flightService;
  }

  @GetMapping
  public Iterable<Flight> getFlights() {
    return flightService.getFlights();
  }

  @PostMapping("/delay")
  public Flight updateFlight(@RequestBody DelayDetails delay) {
    return flightService.delayFlight(delay.flightNumber(), delay.minutes());
  }

}

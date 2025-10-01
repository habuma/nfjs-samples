package com.example.trips;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/trips")
public class TripsApiController {

  private final TripRepository tripRepository;

  public TripsApiController(TripRepository tripRepository) {
    this.tripRepository = tripRepository;
  }

  @GetMapping
  public Iterable<Trip> listTrips() {
    return tripRepository.findAll();
  }

}

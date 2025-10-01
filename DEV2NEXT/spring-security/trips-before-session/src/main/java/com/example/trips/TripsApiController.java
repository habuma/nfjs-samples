package com.example.trips;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
    var trips = tripRepository.findAll();
    System.err.println(trips);
    return trips;
  }

  @PostMapping
  public Trip addTrip(Trip trip) {
    return tripRepository.save(trip);
  }

}

package com.example.trips;

import org.springframework.data.repository.CrudRepository;

public interface TripRepository extends CrudRepository<Trip, Long> {

  Iterable<Trip> findByTraveler(String traveler);

}

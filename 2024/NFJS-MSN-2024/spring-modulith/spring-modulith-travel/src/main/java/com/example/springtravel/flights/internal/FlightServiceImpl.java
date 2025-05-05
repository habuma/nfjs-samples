package com.example.springtravel.flights.internal;

import com.example.springtravel.flights.DelayEvent;
import com.example.springtravel.flights.FlightService;
import com.example.springtravel.notifications.NotificationService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FlightServiceImpl implements FlightService {

  private final FlightRepository flightRepository;
  private final ApplicationEventPublisher events;

  public FlightServiceImpl(FlightRepository flightRepository, ApplicationEventPublisher events) {
    this.flightRepository = flightRepository;
    this.events = events;
  }

  @Override
  public Iterable<Flight> getFlights() {
    return flightRepository.findAll();
  }

  @Override
  public Flight createFlight(Flight flight) {
    return flightRepository.save(flight);
  }

  @Override
  @Transactional
  public Flight delayFlight(String flightNumber, long minutes) {
    Flight flight = flightRepository.findByFlightNumber(flightNumber).orElseThrow();
    Flight updatedFlight = new Flight(
        flight.id(),
        flightNumber,
        flight.origin(),
        flight.destination(),
        flight.departureTime().plusMinutes(minutes));
    events.publishEvent(new DelayEvent(flightNumber, updatedFlight.departureTime()));
    return updatedFlight;
  }
}

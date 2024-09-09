package com.example.springtravel.flights;

public interface FlightService {

  Iterable<Flight> getFlights();

  Flight createFlight(Flight flight);

  Flight delayFlight(String flightNumber, long minutes);

}

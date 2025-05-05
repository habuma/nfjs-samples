package com.example.springtravel.flights;

import com.example.springtravel.flights.internal.Flight;

public interface FlightService {

  Iterable<Flight> getFlights();

  Flight createFlight(Flight flight);

  Flight delayFlight(String flightNumber, long minutes);

}

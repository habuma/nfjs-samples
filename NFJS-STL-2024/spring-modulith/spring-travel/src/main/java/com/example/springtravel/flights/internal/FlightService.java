package com.example.springtravel.flights.internal;

import com.example.springtravel.flights.Flight;

public interface FlightService {

  Iterable<Flight> getFlights();

  Flight createFlight(Flight flight);

  Flight delayFlight(String flightNumber, long minutes);

}

package com.example.springtravel.flights;

import java.time.LocalTime;

public record FlightDelayedEvent(
    String flightNumber,
    LocalTime newDepartureTime) {
}

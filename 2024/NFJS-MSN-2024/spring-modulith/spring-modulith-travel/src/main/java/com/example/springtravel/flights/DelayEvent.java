package com.example.springtravel.flights;

import java.time.LocalTime;

public record DelayEvent(String flightNumber, LocalTime newDepartureTime) {
}

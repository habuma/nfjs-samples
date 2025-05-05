package com.example.springtravel.flights;

import org.springframework.data.annotation.Id;

import java.time.LocalTime;

public record Flight(
    @Id Long id,
    String flightNumber,
    String origin,
    String destination,
    LocalTime departureTime) {
}

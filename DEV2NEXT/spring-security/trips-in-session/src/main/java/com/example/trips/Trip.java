package com.example.trips;

import org.springframework.data.annotation.Id;

import java.sql.Date;

public record Trip(
    @Id
    Long id,
    String traveler,
    String origin,
    String destination,
    Date departureDate,
    Date returnDate) {
}

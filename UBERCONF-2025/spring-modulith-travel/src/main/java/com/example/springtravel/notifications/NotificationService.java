package com.example.springtravel.notifications;

import com.example.springtravel.flights.Flight;

import java.time.LocalDateTime;
import java.time.LocalTime;

public interface NotificationService {

  void notifyDelay(String flightNumber, LocalTime departureTime);

}

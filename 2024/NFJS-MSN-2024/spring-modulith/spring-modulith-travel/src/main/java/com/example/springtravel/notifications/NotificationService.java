package com.example.springtravel.notifications;

import com.example.springtravel.flights.internal.Flight;

import java.time.LocalTime;

public interface NotificationService {

  void notifyDelay(String flightNumber, LocalTime departureTime);

}

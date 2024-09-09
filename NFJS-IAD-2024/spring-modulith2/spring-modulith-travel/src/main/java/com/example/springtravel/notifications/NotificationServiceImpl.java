package com.example.springtravel.notifications;

import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class NotificationServiceImpl implements NotificationService {

  @Override
  public void notifyDelay(String flightNumber, LocalTime newDepartureTime) {
    System.out.println(
        "Flight " + flightNumber + " has been delayed. " +
        "New departure time: " + newDepartureTime + ".");
  }
}

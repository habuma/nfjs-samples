package com.example.springtravel.notifications.internal;

import com.example.springtravel.notifications.NotificationService;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class NotificationServiceImpl implements NotificationService {

  @Override
  public void notifyDelay(String flightNumber, LocalTime departureTime) {
    System.out.println(
        "Flight " + flightNumber + " has been delayed. " +
        "New departure time: " + departureTime + ".");
  }


}

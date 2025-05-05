package com.example.springtravel.notifications.internal;

import com.example.springtravel.flights.internal.Flight;
import com.example.springtravel.notifications.NotificationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Service
public class NotificationServiceImpl implements NotificationService {

  private static final Logger log = LoggerFactory.getLogger(NotificationServiceImpl.class);

  @Override
  public void notifyDelay(String flightNumber, LocalTime departureTime) {
    System.out.println(
        "Flight " + flightNumber + " has been delayed. " +
        "New departure time: " + departureTime + ".");
  }
}

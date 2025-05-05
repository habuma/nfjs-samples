package com.example.springtravel.notifications;

import java.time.LocalTime;

public interface NotificationService {

  void notifyDelay(String flightNumber, LocalTime newDepartureTime);

}

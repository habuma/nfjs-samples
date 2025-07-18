package com.example.springtravel.notifications;

import com.example.springtravel.flights.FlightService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.ApplicationModuleTest;

@ApplicationModuleTest
public class NotificationsModuleIntegrationTests {

  @Autowired
  NotificationService notificationService;

//  @Autowired
//  FlightService flightService;

  @Test
  public void applicationContextLoads() {
    Assertions.assertNotNull(notificationService);
    // do additional assertions or interactions with the notificationService
//    Assertions.assertNotNull(flightService);
  }

}

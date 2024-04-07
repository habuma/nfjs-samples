package com.example.springtravel.notifications;

import com.example.springtravel.flights.internal.FlightService;
import com.example.springtravel.notifications.internal.NotificationService;
import org.assertj.core.api.Assertions;
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
  void contextLoads() {
    Assertions.assertThat(notificationService).isNotNull();
  }

}


package com.example.springtravel.notifications;

import com.example.springtravel.flights.DelayEvent;
import com.example.springtravel.flights.FlightService;
import com.example.springtravel.notifications.internal.NotificationEventHandler;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.ApplicationModuleTest;

import java.time.LocalTime;

@ApplicationModuleTest
public class NotificationsModuleIntegrationTests {

  @Autowired
  private NotificationEventHandler notificationEventHandler;

  @Test
  public void testThatServicesAreAvailable() {
    Assertions.assertThat(notificationEventHandler).isNotNull();
    notificationEventHandler.handleNotification(
        new DelayEvent("123", LocalTime.now()));
  }

}

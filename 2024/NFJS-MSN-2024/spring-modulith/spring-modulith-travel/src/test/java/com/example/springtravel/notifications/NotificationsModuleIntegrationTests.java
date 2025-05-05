package com.example.springtravel.notifications;

import com.example.springtravel.flights.DelayEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.ApplicationModuleTest;

import java.time.LocalTime;

@ApplicationModuleTest
public class NotificationsModuleIntegrationTests {

  @Autowired
  private NotificationEventHandler notificationEventHandler;

  @Test
  void contextLoads() {
    notificationEventHandler.on(new DelayEvent("LH123", LocalTime.of(16,30)));
  }

}

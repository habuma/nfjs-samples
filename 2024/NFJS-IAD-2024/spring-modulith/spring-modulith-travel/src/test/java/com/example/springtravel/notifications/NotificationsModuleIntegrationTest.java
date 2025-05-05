package com.example.springtravel.notifications;

import com.example.springtravel.flights.DelayEvent;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.modulith.test.ApplicationModuleTest;

import java.time.LocalTime;

@ApplicationModuleTest
public class NotificationsModuleIntegrationTest {

  @Autowired
  NotificationEventHandler notificationEventHandler;

  @Test
  void contextLoads() {
    System.err.println("NotificationsModuleIntegrationTest.contextLoads");
    System.err.println("notificationEventHandler = " + notificationEventHandler);
    notificationEventHandler.handleDelayEvent(new DelayEvent("1", LocalTime.now()));
  }

}

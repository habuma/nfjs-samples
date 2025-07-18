package com.example.springtravel.notifications.internal;

import com.example.springtravel.flights.DelayEvent;
import com.example.springtravel.notifications.NotificationService;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
public class NotificationEventHandler {

  private final NotificationService notificationService;

  public NotificationEventHandler(NotificationService notificationService) {
    this.notificationService = notificationService;
  }

  @Async
  @TransactionalEventListener
  public void handleDelayEvent(DelayEvent event) {
    notificationService.notifyDelay(
        event.flightNumber(), event.newDepartureTime());
  }

}

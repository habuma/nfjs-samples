package com.example.springtravel.notifications;

import com.example.springtravel.flights.DelayEvent;
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
  public void handleDelayEvent(DelayEvent delayEvent) {
    notificationService.notifyDelay(delayEvent.flightNumber(), delayEvent.newDepartureTime());
  }

}

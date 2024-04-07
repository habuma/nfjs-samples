package com.example.springtravel.notifications.internal;

import com.example.springtravel.flights.FlightDelayedEvent;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionalEventListener;

@Service
public class NotificationServiceImpl implements NotificationService {

  private void notifyDelay(FlightDelayedEvent event) {
    System.out.println(
        "Flight " + event.flightNumber() + " has been delayed. " +
        "New departure time: " + event.newDepartureTime() + ".");
  }

  @TransactionalEventListener
  @Async
  public void onFlightDelayed(FlightDelayedEvent event) {
    notifyDelay(event);
  }


  @TransactionalEventListener
  @Async
  public void onFlightDelayed2(FlightDelayedEvent event) {
    System.err.println("I also got called!");
  }

}

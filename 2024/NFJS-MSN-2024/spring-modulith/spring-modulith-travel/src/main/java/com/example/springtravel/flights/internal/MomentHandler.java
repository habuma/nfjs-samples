package com.example.springtravel.flights.internal;

import org.springframework.context.event.EventListener;
import org.springframework.modulith.moments.DayHasPassed;
import org.springframework.modulith.moments.HourHasPassed;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MomentHandler {
  @Async
  @EventListener
  void on(DayHasPassed dayHasPassed) {
    System.err.println("Day has passed: " + dayHasPassed.getDate());
  }

  @Async
  @EventListener
  void on(HourHasPassed hourHasPassed) {
    System.err.println("Hour has passed: " + hourHasPassed.getTime());
  }
}

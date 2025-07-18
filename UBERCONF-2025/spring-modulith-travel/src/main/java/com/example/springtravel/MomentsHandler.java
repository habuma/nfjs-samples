package com.example.springtravel;

import org.springframework.context.event.EventListener;
import org.springframework.modulith.moments.DayHasPassed;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class MomentsHandler {

  @Async
  @EventListener
  void on(DayHasPassed event) {
    System.err.println("Day has passed: " + event.getDate());
  }

}

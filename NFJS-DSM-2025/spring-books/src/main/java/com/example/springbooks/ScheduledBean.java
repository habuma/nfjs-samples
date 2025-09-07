package com.example.springbooks;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class ScheduledBean {

  AtomicInteger counter = new AtomicInteger(0);

  @Scheduled(fixedRateString = "10s")
  public void scheduled() {
    System.err.println("Scheduled task executed " + counter.incrementAndGet() + " times");
  }

}

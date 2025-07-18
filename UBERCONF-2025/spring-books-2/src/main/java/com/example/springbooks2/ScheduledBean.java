package com.example.springbooks2;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledBean {

  @Scheduled(initialDelayString="10s", fixedRateString = "5s")
  public void ping() {
    System.err.println("ScheduledBean.ping() called");
  }

}

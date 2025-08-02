package com.example.ordwhatsnewspring;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

public class SomeService {

  private static final Logger LOGGER = LoggerFactory.getLogger(SomeService.class);

  public String getGreeting() {

    MDC.put("apiVersion", "1.1");
    LOGGER.info("SomeService getGreeting");
    MDC.remove("apiVersion");

    return "Hello from SomeService!";
  }

  public String getFarewell() {
    return "Goodbye from SomeService!";
  }

}

package com.example.booksmsnjdbc;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.annotation.Observed;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

  private final ObservationRegistry registry;

  public HelloServiceImpl(ObservationRegistry registry) {
    this.registry = registry;
  }

  @Override
  @Observed(name="helloObservation")
  public String hello(String who) {

    try {
      Thread.sleep(30000);
    } catch (InterruptedException e) {}

      return "Hello!";
  }

}

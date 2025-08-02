package com.example.ordwhatsnewspring;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicInteger;

@RestController
public class HelloController {

  @Value("#{environment['HABUMA_NAME'] ?: 'default'}")
  private String habumaName;

  private final SomeService someService;
  private final SomeComponent someComponent;

  public HelloController(SomeService someService, SomeComponent someComponent) {
    this.someService = someService;
    this.someComponent = someComponent;
  }

  @GetMapping(path="/{version}/hello", version="1.0")
  public String sayHello() {
    return "Hello, World!";
  }

  @GetMapping(path="/{version}/hello", version = "1.1")
  public String sayHello1_1(@PathVariable String version) {
    System.err.println("Version: " + version);
    return "Hello, World (1.1)!  : " + someService.getGreeting() +
        " (habumaName: " + habumaName + ")" +
        " / SOMECOMPONENT: " + someComponent.getName();
  }

  AtomicInteger counter = new AtomicInteger();

  @Scheduled(fixedDelayString="2s")
  public void logGreetingCount() {
    // do something here
    System.err.println("Greeting count: " + counter.incrementAndGet());
    // do something after
  }

}

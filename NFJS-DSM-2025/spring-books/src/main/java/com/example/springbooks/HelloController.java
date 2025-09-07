package com.example.springbooks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  private static final Logger logger = LoggerFactory.getLogger(HelloController.class);

  private final GreetingService greetingService;
  private final SomeService someService;

  public HelloController(GreetingService greetingService, SomeService myService) {
    this.greetingService = greetingService;
    this.someService = myService;
  }

  @GetMapping("/greeting/{name}")
  public String greeting(@PathVariable String name) {

    MDC.put("apple", "green");
    MDC.put("banana", "yellow");
    logger.info("Saying greeting to " + name);
    MDC.clear();

    someService.doSomething();

    return greetingService.sayHello(name);
  }


  @GetMapping(path="/hello", version="1.0")
  public String hello() {
    return "Hello, World!";
  }

  @GetMapping(path="/hello", version = "2.0")
  public String helloV2() {
    return "Hello, World! (v2)";
  }

  @GetMapping(path="/hello", version = "2.5")
  public String helloV2_5() {
    return "Hello, World! (v2.5)";
  }
  
}

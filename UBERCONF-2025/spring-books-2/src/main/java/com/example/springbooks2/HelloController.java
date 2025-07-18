package com.example.springbooks2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

  private static final Logger logger = LoggerFactory.getLogger(SpringBooks2Application.class);
  private final ThemeParkApi themeParkApi;
  private final ThingService thingService;

  public HelloController(ThemeParkApi themeParkApi, ThingService thingService) {
    this.themeParkApi = themeParkApi;
    this.thingService = thingService;
  }

  @GetMapping(path="/{version}/hello", version = "1.0.0+")
  public String hello(@PathVariable("version") String version) {
    return "Hello, World!  ("+version + "))";
  }

  @GetMapping(path="/{version}/hello", version = "1.1.0")
  public String hello1_1(@PathVariable("version") String version) {

    MDC.put("HELLO_VERSION", version);
    logger.info("Saying hello");
    MDC.remove("HELLO_VERSION");

    System.err.println("THING SERVICE NAME: " + thingService.getName());

    return "Hello, UberConf!  ("+version + "))";
  }

  @GetMapping("/destinations")
  public DestinationsResponse getDestinations() {
    return themeParkApi.getDestinations();
  }

}

package com.example.springbooks;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HabumeController {

  @Value("#{environment['HABUMA_NAME'] ?: 'habuma'}")
  String someValue;

  @GetMapping("/habuma")
  public String habuma() {
    return someValue;
  }

}

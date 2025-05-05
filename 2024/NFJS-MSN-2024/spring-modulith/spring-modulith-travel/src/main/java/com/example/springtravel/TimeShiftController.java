package com.example.springtravel;

import org.springframework.modulith.moments.support.TimeMachine;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
public class TimeShiftController {

  private final TimeMachine timeMachine;

  TimeShiftController(TimeMachine timeMachine) {
    this.timeMachine = timeMachine;
  }

  @PostMapping("/shift")
  public String shiftTime() {
    timeMachine.shiftBy(Duration.ofDays(1));
    return "Time shifted";
  }

}

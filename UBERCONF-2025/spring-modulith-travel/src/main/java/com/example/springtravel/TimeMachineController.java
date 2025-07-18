package com.example.springtravel;

import org.springframework.modulith.moments.support.TimeMachine;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Duration;

@RestController
public class TimeMachineController {

  private final TimeMachine timeMachine;

  public TimeMachineController(TimeMachine timeMachine) {
    this.timeMachine = timeMachine;
  }

  @PostMapping("/forward")
  public String forward() {
    timeMachine.shiftBy(Duration.ofDays(3));
    return "Time machine activated: traveling forward in time!";
  }

}

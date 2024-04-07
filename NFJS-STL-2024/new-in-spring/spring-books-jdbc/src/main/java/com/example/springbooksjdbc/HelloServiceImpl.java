package com.example.springbooksjdbc;

import io.micrometer.observation.Observation;
import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.annotation.Observed;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceImpl implements HelloService {

  private final ObservationRegistry obsReg;

  public HelloServiceImpl(ObservationRegistry obsReg) {
    this.obsReg = obsReg;
  }

  @Observed(name="AOP_SAY_HELLO")
  public String sayHello(String name) {
    try {
      Thread.sleep(10000);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
    return "Hello, " + name + "!";
  }

//  public String sayHello(String name) {
//    return Observation.createNotStarted("SAY_HELLO", obsReg)
//        .observe(() -> sayHelloTarget(name));
//  }
//
//  private String sayHelloTarget(String name) {
//    try {
//      Thread.sleep(10000);
//    } catch (InterruptedException e) {
//      throw new RuntimeException(e);
//    }
//    return "Hello, " + name + "!";
//  }

}

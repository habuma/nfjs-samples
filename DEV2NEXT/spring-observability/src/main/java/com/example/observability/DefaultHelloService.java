package com.example.observability;

import io.micrometer.observation.annotation.Observed;
import org.springframework.stereotype.Service;

@Service
public class DefaultHelloService implements HelloService {

  @Override
  @Observed(name="say.hello")
  public String sayHello(String name) {
    return "Hello, " + name + "!";
  }

}

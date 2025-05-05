package com.example.springtravel;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

public class ModulithTests {

  @Test
  public void printModules() {
    var modules = ApplicationModules.of(SpringTravelApplication.class);
    modules.stream()
        .forEach(System.out::println);
  }

  @Test
  public void verifyModules() {
    var modules = ApplicationModules.of(SpringTravelApplication.class);
    modules.verify();
  }


}

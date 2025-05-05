package com.example.springtravel;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;

@SpringBootTest
class SpringTravelApplicationTests {

  @Test
  void contextLoads() {
  }

  @Test
  void testModules() {
    ApplicationModules modules = ApplicationModules
                        .of(SpringTravelApplication.class);
    modules.stream().forEach(System.out::println);

    modules.verify();
  }

}

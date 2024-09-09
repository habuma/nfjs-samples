package com.example.springtravel;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

@SpringBootTest
class SpringTravelApplicationTests {

  @Test
  void contextLoads() {
  }

  @Test
  public void printModules() {
    var modules = ApplicationModules.of(SpringTravelApplication.class);
    modules.stream().forEach(System.out::println);
  }

  @Test
  public void verifyModules() {
    var modules = ApplicationModules.of(SpringTravelApplication.class);

    modules.verify();
  }

  @Test
  void writeDocumentationSnippets() {
    var modules = ApplicationModules.of(SpringTravelApplication.class);

    new Documenter(modules).writeIndividualModulesAsPlantUml();
    new Documenter(modules).writeDocumentation();

  }

}

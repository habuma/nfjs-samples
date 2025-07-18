package com.example.springtravel;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

public class ModularityTests {

  @Test
  public void verifyModularity() {
    var modules = ApplicationModules.of(SpringTravelApplication.class);
    modules.verify();
  }

  @Test
  public void describeModules() {
    var modules = ApplicationModules.of(SpringTravelApplication.class);
    modules.stream().forEach(System.out::println);
  }

  @Test
  void writeDocumentationSnippets() {
    var modules = ApplicationModules.of(SpringTravelApplication.class);
    new Documenter(modules)
        .writeModulesAsPlantUml()
        .writeIndividualModulesAsPlantUml()
        .writeModuleCanvases();
  }

}

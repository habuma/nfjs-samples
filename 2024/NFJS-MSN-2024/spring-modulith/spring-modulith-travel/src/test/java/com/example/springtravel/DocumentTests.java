package com.example.springtravel;

import jdk.jshell.Diag;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;
import org.springframework.modulith.docs.Documenter;

public class DocumentTests {

  ApplicationModules modules = ApplicationModules.of(SpringTravelApplication.class);

  @Test
  void writeDocumentationSnippets() {
    Documenter.DiagramOptions options = Documenter.DiagramOptions.defaults()
        .withStyle(Documenter.DiagramOptions.DiagramStyle.UML);

    new Documenter(modules)
        .writeModulesAsPlantUml(options)
        .writeIndividualModulesAsPlantUml()
        .writeModuleCanvases();
  }

}

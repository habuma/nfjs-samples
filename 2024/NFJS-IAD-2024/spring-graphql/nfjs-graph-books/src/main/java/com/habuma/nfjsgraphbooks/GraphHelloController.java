package com.habuma.nfjsgraphbooks;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GraphHelloController {

  @QueryMapping("hello")
  public String hello() {
    return "Hello, world!";
  }

}

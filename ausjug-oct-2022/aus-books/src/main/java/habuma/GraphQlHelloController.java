package habuma;

import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class GraphQlHelloController {

  @QueryMapping("hello")
  public String hello() {
    return "Hello GraphQL!";
  }
  
}

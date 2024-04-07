package habuma;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

@Controller
public class HelloGraphQlController {

  @QueryMapping(name="hello")
  public String hello() {
    return "Hello GraphQL!";
  }
  
  @QueryMapping(name="helloTo")
  public String helloTo(@Argument("who") String who) {
    return "Hello, " + who + "!";
  }
  
  @QueryMapping(name="howdy")
  public Greeting howdy() {
    return new Greeting("Howdy folks!", new Integer(123));
  }
  
}

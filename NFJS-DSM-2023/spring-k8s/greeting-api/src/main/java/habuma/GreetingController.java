package habuma;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/greetings")
public class GreetingController {
  
  private GreetingProps props;
  
  @Autowired
  public ApplicationContext context;

  public GreetingController(GreetingProps props) {
    this.props = props;
  }

  @GetMapping("/hello")
  public Mono<String> hello() {
    System.out.println("Saying hello...");
    return Mono.just(props.getHello());
  }
  
  @GetMapping("/goodbye")
  public Mono<String> goodbye() {
    System.out.println("Saying goodbye...");
    return Mono.just(props.getGoodbye());
  }
  
}

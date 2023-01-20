package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class HelloController {

  @GetMapping("/hello")
  public Mono<String> hello() {
    return Mono.just("Hello world!");
  }
  
  @GetMapping("/bye")
  public Mono<String> bye() {
    if (Math.random() < 0.5) {
      throw new CrapHappenedException("The value is too low");
    }
    
    return Mono.just("Laters gaters!");
  }
  
}

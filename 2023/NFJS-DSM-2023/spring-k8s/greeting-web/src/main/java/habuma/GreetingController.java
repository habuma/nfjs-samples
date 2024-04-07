package habuma;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.function.client.WebClient;

@Controller
@RequestMapping("/greeting")
public class GreetingController {

  private WebClient webClient;

  public GreetingController(WebClient webClient) {
    this.webClient = webClient;
  }
  
  @GetMapping("/hello")
  public String hello(final Model model) {
    model.addAttribute("greeting", 
        webClient.get()
          .uri("/greetings/hello")
          .retrieve()
          .bodyToMono(String.class));
    return "hello-view";
  }
  
  @GetMapping("/goodbye")
  public String goodbye(final Model model) {
    model.addAttribute("greeting", 
        webClient.get()
          .uri("/greetings/goodbye")
          .retrieve()
          .bodyToMono(String.class));
    return "goodbye-view";
  }
  
}

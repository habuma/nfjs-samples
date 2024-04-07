package habuma.hellok8sclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloClientController {
    @GetMapping("/hello")
    public String hello() {
        return new RestTemplate()
                .getForObject("http://hello-k8s/hello", String.class);
    }
}

package habuma.cmhhelloclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String sayHello() {
        RestTemplate rest = new RestTemplate();
        return rest.getForObject("http://cmh-books-api/hello", String.class);
    }

}

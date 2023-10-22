package com.example.helloclient;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class HelloClientController {

    @GetMapping("/greetings")
    public String greetings() {
        return new RestTemplate()
                .getForObject("http://hello-k8s/hello", String.class);
    }

}

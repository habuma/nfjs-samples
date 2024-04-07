package habuma.reactivebooks;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Mono<String> hello() {
        Mono<String> mono = Mono
                .just("Hello, world!")
                .map(this::toUpperCase);
        System.out.println("RETURNING FROM hello()");
        return mono;
    }

    String toUpperCase(String input) {
        System.out.println(" IN toUpperCase() ");
        return input.toUpperCase();
    }

}

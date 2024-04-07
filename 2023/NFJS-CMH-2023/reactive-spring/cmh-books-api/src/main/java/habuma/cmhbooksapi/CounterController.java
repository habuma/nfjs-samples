package habuma.cmhbooksapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class CounterController {

    @GetMapping(path="/counter", produces="application/stream+json")
    public Flux<String> counter() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(x -> "COUNT: " + x);
    }

}

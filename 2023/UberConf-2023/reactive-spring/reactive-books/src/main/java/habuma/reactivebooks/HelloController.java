package habuma.reactivebooks;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.Optional;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public Mono<String> hello() {
        return Mono.just("Hello, world!");
    }

    @GetMapping(path="/counter", produces="application/stream+json")
    public Flux<CountEntry> counter() {
        return Flux.interval(Duration.ofSeconds(1L))
                .map(c -> new CountEntry(c, System.currentTimeMillis()))
                .take(10);
    }

    private static record CountEntry(long count, long timestamp) {
    }
}

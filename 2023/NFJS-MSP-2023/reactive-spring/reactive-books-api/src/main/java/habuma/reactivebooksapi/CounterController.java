package habuma.reactivebooksapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class CounterController {

    @GetMapping(path="/counter", produces="application/stream+json")
    public Flux<CounterResponse> counter() {
        return Flux.interval(Duration.ofSeconds(1))
//            .take(10)
            .map(i -> new CounterResponse("tick #" + i));
    }

    private static record CounterResponse(String message) {}

}

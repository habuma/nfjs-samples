package habuma.reactivebooks;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.time.Duration;

@RestController
public class CountController {

    @GetMapping(path="/count")
    public Flux<CountResponse> count() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(n -> new CountResponse(n + " Mississippi"));
    }

    static record CountResponse(String message) {}

}

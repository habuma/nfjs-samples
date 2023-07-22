package habuma.rsocketserver;

import org.springframework.messaging.Message;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@Controller
public class HelloController {

    // request-response
    @MessageMapping("hello")
    public Mono<String> hello() {
        return Mono.just("Hello, world!");
    }

    // request-stream
    @MessageMapping("counter")
    public Flux<Long> counter() {
        return Flux.interval(Duration.ofSeconds(1));
    }

    // fire-and-forget
    @MessageMapping("bye")
    public Mono<Void> bye(String message) {
        System.out.println("Client said bye. Their message: " + message);
        return Mono.empty();
    }

    // channel
    @MessageMapping("shout")
    public Flux<String> shout(Flux<String> shouts) {
        return shouts.map(s -> s.toUpperCase());
    }

}

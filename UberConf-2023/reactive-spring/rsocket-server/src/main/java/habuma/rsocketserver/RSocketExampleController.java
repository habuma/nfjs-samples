package habuma.rsocketserver;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
public class RSocketExampleController {

    // request/reply
    @MessageMapping("hello")
    public Mono<String> hello() {
        return Mono.just("Hello, world!");
    }

    @MessageMapping("hello/{name}")
    public Mono<String> helloTo(@DestinationVariable("name") String name) {
        return Mono.just("Hello, " + name + "!");
    }

    // request stream
    @MessageMapping("counter")
    public Flux<Long> counter() {
        return Flux.interval(java.time.Duration.ofSeconds(1));
    }

    // fire-and-forget
    @MessageMapping("bye")
    public Mono<Void> bye(String name) {
        System.out.println("Received: " + name);
        return Mono.empty();
    }

    // channel
    @MessageMapping("channel")
    public Flux<String> channel(Flux<String> input) {
        return input.map(s -> s.toUpperCase());
    }


}

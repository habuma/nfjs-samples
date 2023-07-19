package habuma.rsocketclient;

import org.springframework.messaging.rsocket.service.RSocketExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RSocketExchange
public interface HelloClient {

    // request-response
    @RSocketExchange("hello")
    Mono<String> hello();

    @RSocketExchange("counter")
    Flux<Long> counter();

    @RSocketExchange("bye")
    Mono<Void> bye(String message);

    @RSocketExchange("shout")
    Flux<String> shout(Flux<String> shouts);

}

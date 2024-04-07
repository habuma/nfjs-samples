package com.example.rsocketclient;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.rsocket.service.RSocketExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RSocketExchange
public interface RSocketClient {

    @RSocketExchange("hello")
    Mono<String> hello();

    @RSocketExchange("hello/{name}")
    Mono<String> helloTo(@DestinationVariable("name") String name);

    @RSocketExchange("bye")
    Mono<Void> bye(String name);

    @RSocketExchange("channel")
    Flux<String> channel(Flux<String> input);

    @RSocketExchange("counter")
    Flux<Long> counter();


}

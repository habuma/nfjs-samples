package com.example.rsocketclient;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class RsocketClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(RsocketClientApplication.class, args);
    }


    @Bean
    ApplicationRunner go(RSocketClient client) {
        return args -> {
            client.hello().subscribe(m -> System.out.println("Received: " + m));
            client.helloTo("Craig").subscribe(m -> System.out.println("2nd Received: " + m));


            client.bye("Everyone").subscribe();

            client.counter().subscribe(l -> System.out.println("Counter: " + l));

            client.channel(Flux.just("apple", "banana", "cherry"))
                    .subscribe(s -> System.out.println("Received: " + s));

            Thread.sleep(10000);
        };
    }
}

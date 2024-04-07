package habuma.rsocketclient;

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
    ApplicationRunner go(HelloClient client) {
        return args -> {

            // request-response
            client.hello()
                    .doOnNext(s -> System.out.println("Got: " + s))
                    .subscribe();

            // request-stream
            client.counter()
                    .doOnNext(c -> System.out.println("Counter: " + c))
                    .subscribe();

            // first-and-forget
            client.bye("See ya!").subscribe();

            // channel
            Flux<String> shouts = Flux.just("Hey!", "Dude!", "What's up!");
            client.shout(shouts)
                    .doOnNext(s -> System.out.println("Got: " + s))
                    .subscribe();

            // keep the main thread alive long enough for reactive threads to complete
            Thread.sleep(5000);
        };
    }

}

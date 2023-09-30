package habuma.cmhbooksapi;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

import java.time.Duration;

public class ReactiveTest {

    @Test
    public void simpleFlux() {
        Flux<String> fruitFlux =
                Flux.just("apples", "bananas", "cherries", "dates");

        fruitFlux
            .map(String::toUpperCase)
            .subscribe(fruit -> {
                System.out.println("FRUIT: " + fruit);
            });

    }

    @Test
    public void counter() {
        System.out.println("X");
        Flux.interval(Duration.ofSeconds(1L))
                .subscribe(x -> {
                    System.out.println("COUNT: " + x);
                });
    }

    @Test
    public void flatMap() {
        Flux<String> fruitFlux = Flux.just("Apples", "Bananas", "Cherries");

        fruitFlux
            .flatMap(fruit -> {
                return Flux.just(toUpperCase(fruit), toLowerCase(fruit))
                        .subscribeOn(Schedulers.parallel());
            })
            .subscribe(fruit -> {
                System.out.println("FRUIT: " + fruit);
            });
    }

    String toUpperCase(String in) {
        try {
            Thread.sleep((long) (Math.random() * 5));
        } catch (Exception e) {}
        return in.toUpperCase();
    }

    String toLowerCase(String in) {
        try {
            Thread.sleep((long) (Math.random() * 5));
        } catch (Exception e) {}
        return in.toLowerCase();
    }

}

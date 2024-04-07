package habuma.reactivebooks;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;

public class ReactiveFunTest {

    @Test
    public void simpleFlux() {
        Flux<String> fruitFlux = Flux.just("Apple", "Banana", "Cherry");
        fruitFlux
                .map(fruit -> fruit.toUpperCase())
                .doOnNext(fruit -> System.out.println("Here's a fruit: " + fruit))
                .subscribe();

    }

}

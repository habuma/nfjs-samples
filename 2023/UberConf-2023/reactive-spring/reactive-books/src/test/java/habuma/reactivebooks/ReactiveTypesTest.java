package habuma.reactivebooks;

import org.junit.jupiter.api.Test;
import reactor.core.publisher.Flux;
import reactor.core.scheduler.Schedulers;

public class ReactiveTypesTest {
    
    @Test
    public void doSomethingWithFlux() {

        Flux<String> fruitFlux =
                Flux.just("apple", "banana", "cherry", "date");

        fruitFlux
                .map(f -> f.toUpperCase())
                .skip(2)
                .doOnNext(f -> System.out.println(f))
                .subscribe()
        ;
    }

    @Test
    public void doSomethingElseWithFlux() {
        Flux<Player> playerFlux = Flux.just(
                new Player("Michael Jordan", "Chicago Bulls"),
                new Player("Nikola Jokic", "Denver Nuggets"),
                new Player("LeBron James", "Los Angeles Lakers"),
                new Player("Kevin Durant", "Brooklyn Nets")
        );

        System.out.println("TEST THREAD: " + Thread.currentThread());

        playerFlux
                .flatMap(p ->
                        Flux.just(p)
                                .map(this::transform)
                                .subscribeOn(Schedulers.parallel())
                )
                .subscribe(System.out::println);

        try {
            Thread.sleep(10000);
        } catch (Exception e) {}
    }

    private String transform(Player p) {
        try {
            System.out.println("TRANSFORM THREAD: " + Thread.currentThread());
            Thread.sleep((long)(Math.random() * 5000.0));
        } catch (Exception e) {}
        return p.name() + " of the " + p.team();
    }

    private static record Player(String name, String team) {
    }
}

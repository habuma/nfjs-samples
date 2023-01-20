package habuma;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;

public class FluxTransformingTest {
//
//  //tag::skipAFew[]
//  @Test
//  public void skipAFew() {
//    Flux<String> countFlux = Flux.just(
//        "one", "two", "skip a few", "ninety nine", "one hundred")
//        .skip(3);
//   
//    StepVerifier.create(countFlux)
//        .expectNext("ninety nine", "one hundred")
//        .verifyComplete();
//  }
//  //end::skipAFew[]
//
//  //tag::skipAFewSeconds[]
//  @Test
//  public void skipAFewSeconds() {
//    Flux<String> countFlux = Flux.just(
//        "one", "two", "skip a few", "ninety nine", "one hundred")
//        .delayElements(Duration.ofSeconds(1))
//        .skip(Duration.ofSeconds(4));
//   
//    StepVerifier.create(countFlux)
//        .expectNext("ninety nine", "one hundred")
//        .verifyComplete();
//  }
//  //end::skipAFewSeconds[]
//  
//  //tag::take[]
//  @Test
//  public void take() {
//    Flux<String> nationalParkFlux = Flux.just(
//        "Yellowstone", "Yosemite", "Grand Canyon", "Zion", "Acadia")
//        .take(3);
//   
//    StepVerifier.create(nationalParkFlux)
//        .expectNext("Yellowstone", "Yosemite", "Grand Canyon")
//        .verifyComplete();
//  }
//  //end::take[]
//  
//  //tag::takeForAwhile[]
//  @Test
//  public void takeForAwhile() {
//    Flux<String> nationalParkFlux = Flux.just(
//        "Yellowstone", "Yosemite", "Grand Canyon", "Zion", "Grand Teton")
//        .delayElements(Duration.ofSeconds(1))
//        .take(Duration.ofMillis(3500));
//   
//    StepVerifier.create(nationalParkFlux)
//        .expectNext("Yellowstone", "Yosemite", "Grand Canyon")
//        .verifyComplete();
//  }
//  //end::takeForAwhile[]
//  
//  //tag::filter[]
//  @Test
//  public void filter() {
//    Flux<String> nationalParkFlux = Flux.just(
//        "Yellowstone", "Yosemite", "Grand Canyon", "Zion", "Grand Teton")
//        .filter(np -> !np.contains(" "));
//   
//    StepVerifier.create(nationalParkFlux)
//        .expectNext("Yellowstone", "Yosemite", "Zion")
//        .verifyComplete();
//  }
//  //end::filter[]
//  
//  //tag::distinct[]
//  @Test
//  public void distinct() {
//    Flux<String> animalFlux = Flux.just(
//        "dog", "cat", "bird", "dog", "bird", "anteater")
//        .distinct();
//   
//    StepVerifier.create(animalFlux)
//        .expectNext("dog", "cat", "bird", "anteater")
//        .verifyComplete();
//  }
//  //end::distinct[]
//
//  //tag::map[]  
//  @Test
//  public void map() {
//    Flux<Player> playerFlux = Flux
//      .just("Michael Jordan", "Scottie Pippen", "Steve Kerr")
//      .map(n -> {
//        String[] split = n.split("\\s");
//        return new Player(split[0], split[1]);
//      });
//    
//    StepVerifier.create(playerFlux)
//        .expectNext(new Player("Michael", "Jordan"))
//        .expectNext(new Player("Scottie", "Pippen"))
//        .expectNext(new Player("Steve", "Kerr"))
//        .verifyComplete();
//  }
//  //end::map[]  
//  
  //tag::flatMap[]  
  @Test
  public void flatMap() {
    Flux<Player> playerFlux = Flux
      .just("Michael Jordan", "Scottie Pippen", "Steve Kerr")
      .flatMap(n -> Mono.just(n)
          .map(p -> {
        	  System.err.println("THREAD: " + Thread.currentThread().getId());
              String[] split = p.split("\\s");
              return new Player(split[0], split[1]);
            })
          .subscribeOn(Schedulers.parallel())
        );
    
    List<Player> playerList = Arrays.asList(
        new Player("Michael", "Jordan"), 
        new Player("Scottie", "Pippen"), 
        new Player("Steve", "Kerr"));

    playerFlux
    	.subscribe(p -> {
    		System.out.println(p.getLastName());
    	});
    
//    StepVerifier.create(playerFlux)
//        .expectNextMatches(p -> playerList.contains(p))
//        .expectNextMatches(p -> playerList.contains(p))
//        .expectNextMatches(p -> playerList.contains(p))
//        .verifyComplete();
  }
  
  private static class Player {
    private final String firstName;
    private final String lastName;
    
    public Player(String firstName, String lastName) {
    	this.firstName = firstName;
    	this.lastName = lastName;
	}
    
    public String getFirstName() {
		return firstName;
	}
    
    public String getLastName() {
		return lastName;
	}
  }
  //end::player[]  
  
}

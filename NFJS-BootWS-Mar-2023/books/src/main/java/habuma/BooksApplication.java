package habuma;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;

@SpringBootApplication
public class BooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}

	@Bean
	ApplicationRunner dataLoader(BookRepository repo) {
	  return args -> {
	    repo.save(new Book(
	        null, 
	        "1122334455", 
	        "Knitting with Dog Hair", 
	        "Kendall Crolius"))
	      .subscribe();
      repo.save(new Book(
          null, 
          "2233445566", 
          "Crafting with Cat Hair", 
          "Kaori Tsutaya"))
        .subscribe();
	  };
	}
	
  // Use AOP to enable an observation on a method
  @Bean
  ObservedAspect observedAspect(ObservationRegistry observationRegistry) {
    return new ObservedAspect(observationRegistry);
  }
	
}

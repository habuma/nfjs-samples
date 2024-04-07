package habuma;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;

@SpringBootApplication
public class BootBooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootBooksApplication.class, args);
	}
	
	@Bean
	ObservedAspect observedAspect(ObservationRegistry obsReg) {
		return new ObservedAspect(obsReg);
	}
	
	@Bean
	public ApplicationRunner dataLoader(BookRepository repo) {
		return args -> {
			repo.save(new Book(null, 
					"1122334455", 
					"Knitting with Dog Hair",
					"Kendall Crolius"))
			.subscribe();
			
			repo.save(new Book(null,
					"5544332211",
					"Crafting with Cat Hair",
					"Kaori Tsutaya"))
			.subscribe();
		};
	}

}

package habuma;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactiveBooksPersistenceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveBooksPersistenceApplication.class, args);
	}
	
//	@Bean
	public ApplicationRunner dataLoader(BookRepository repo) {
		return args -> {
			repo.save(new Book("1122334455", "Knitting with Dog Hair", "Kendall Crolius")).subscribe();
			repo.save(new Book("5544332211", "Crafting with Cat Hair", "Kaori Tsutaya")).subscribe();
		};
	}

}

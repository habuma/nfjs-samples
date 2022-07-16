package habuma;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ReactiveUberconfBooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveUberconfBooksApplication.class, args);
	}
	
	@Bean
	public ApplicationRunner dataLoader(BookRepository repo) {
		return args -> {
			System.out.println("SAVING BOOKS");
			repo.save(new Book(
					"1111122222", 
					"Knitting with Dog Hair", 
					"Kendall Crolius")).subscribe();
			repo.save(new Book("2222233333", 
					"Crafting with Cat Hair", 
					"Kaori Tsutaya")).subscribe();
			System.out.println("BOOKS SAVED");
		};
	}

}

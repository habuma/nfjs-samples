package habuma;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphBooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphBooksApplication.class, args);
	}
	
	@Bean
	public ApplicationRunner dataLoader(BookRepository repo, AuthorRepo aRepo) {
		return args -> {
			Author kendall = aRepo.save(new Author("Kendall", "Crolius"));
			Author kaori = aRepo.save(new Author("Kaori", "Tsutaya"));
			repo.save(new Book("1122334455", "Knitting with Dog Hair", kendall));
			repo.save(new Book("5544332211", "Crafting with Cat Hair", kaori));
		};
	}

}

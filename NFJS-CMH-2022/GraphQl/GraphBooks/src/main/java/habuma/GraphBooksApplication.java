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
	public ApplicationRunner dataLoader(AuthorRepository authorRepo, BookRepository bookRepo) {
		return args -> {
			Author kendall = authorRepo.save(new Author("Kendall", "Crolius"));
			Author kaori = authorRepo.save(new Author("Kaori", "Tsutaya"));
			
			Book knitting = bookRepo.save(new Book("1111122222", "Knitting with Dog Hair", kendall));
			Book crafting = bookRepo.save(new Book("2222233333", "Crafting with Cat Hair", kaori));
		};
	}

}

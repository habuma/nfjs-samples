package habuma;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GraphqlBooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphqlBooksApplication.class, args);
	}
	
	@Bean
	public ApplicationRunner dataLoader(AuthorRepository authorRepo, BookRepository repo) {
		return args -> {
			Author kendall = authorRepo.save(new Author("Kendall", "Crolius"));
			Author kaori = authorRepo.save(new Author("Kaori", "Tsutaya"));
			
			repo.save(new Book("1111122222", "Knitting with Dog Hair", kendall));
			repo.save(new Book("2222233333", "Crafting with Cat Hair", kaori));
		};
	}

}

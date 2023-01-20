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
	public ApplicationRunner dataLoader(BookRepository bookRepo, AuthorRepository authorRepo) {
		return args -> {
			Author craig = authorRepo.save(new Author("Craig", "Walls"));
			Author ken = authorRepo.save(new Author("Ken", "Kousen"));
			
			bookRepo.save(new Book("1122334455", "Managing Your Manager", ken));
			bookRepo.save(new Book("5544332211", "Spring in Action", craig));
			bookRepo.save(new Book("1212121212", "Build Talking Apps for Alexa", craig));
		};
	}

}

package habuma;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksApplication.class, args);
	}

	
	@Bean
	public ApplicationRunner loader(
			BookRepository bookRepo, 
			AuthorRepository authorRepo, 
			PublisherRepository publisherRepo) {
		
		return args -> {
			Publisher manning = publisherRepo.save(new Publisher("Manning", "Shelter Island"));
			Publisher prag = publisherRepo.save(new Publisher("Pragmatic Bookshelf", "Raleigh"));
			
			Author craig = authorRepo.save(new Author("Craig", "Walls", "habuma"));
			
			bookRepo.save(new Book("1617297577", "Spring in Action, 6th Edition", craig, manning));
			bookRepo.save(new Book("9781680507256", "Build Talking Apps for Alexa", craig, prag));
		};
		
	}
}

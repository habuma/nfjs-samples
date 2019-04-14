package habuma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringdataFunApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringdataFunApplication.class, args);
	}
	
	@Bean
	public CommandLineRunner dataLoader(BookRepository bookRepo, AuthorRepository authorRepo, PublisherRepository publisherRepo, AddressRepository addressRepo) {
		return new CommandLineRunner() {
			
			@Override
			public void run(String... args) throws Exception {
				Address manningAddress = addressRepo.save(new Address("1233 Heartwood Drive", "Cherry Hill", "NJ", "08003"));
				Publisher manning = publisherRepo.save(new Publisher("Manning Publications Co.", manningAddress));
				Author cwalls = authorRepo.save(new Author("Craig", "Walls"));
				bookRepo.save(new Book("9781617292545", "Spring Boot in Action", manning, cwalls, 264));
				bookRepo.save(new Book("9781617291203", "Spring in Action. Fourth Edition", manning, cwalls, 624));


				Address oreillyAddr = addressRepo.save(new Address("1005 Grevenstein Highway North", "Sebastopol", "CA", "95472"));
				Publisher oreilly = publisherRepo.save(new Publisher("O'Reilly Publications", oreillyAddr));
				Author ken = authorRepo.save(new Author("Ken", "Kousen"));
				bookRepo.save(new Book("B01GQTM84E", "Gradle Recipes for Android", oreilly, ken, 168));
			}
		};
	}
}

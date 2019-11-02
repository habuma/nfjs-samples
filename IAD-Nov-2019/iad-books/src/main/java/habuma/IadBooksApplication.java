package habuma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class IadBooksApplication {

	public static void main(String[] args) {
		SpringApplication.run(IadBooksApplication.class, args);
	}
	
	@Bean
	public Thing thing() {
		Thing thing = new Thing();
		thing.setOtherThing(otherThing());
		return thing;
	}

	@Bean
	public Thing otherThing() {
		return new Thing();
	}
	
	
	@Bean
	public CommandLineRunner dataLoader(BooksRepository repo, AuthorRepository aRepo) {
		return args -> {
			Author kendall = aRepo.save(new Author("Kendall", "Crolius"));
			Author kaori = aRepo.save(new Author("Kaori", "Tsutaya"));
			repo.save(new Book("0312152906", "Knitting with Dog Hair: Better a sweater from a dog you know and love than from a sheep you'll never meet", kendall));
			repo.save(new Book("1594745250", "Crafting with Cat Hair", kaori));
		};
	}

}

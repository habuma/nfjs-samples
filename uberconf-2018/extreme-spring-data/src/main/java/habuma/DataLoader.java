package habuma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

	private final BookRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		repo.save(new Book("1234567890", "Spring in Action", "Craig", "Walls"));
		repo.save(new Book("123456789A", "Spring Boot in Action", "Craig", "Walls"));
		repo.save(new Book("123456789B", "Modular Java", "Craig", "Walls"));
		repo.save(new Book("9876543210", "Knitting with Dog Hair", "Kendall", "Crolius"));
		repo.save(new Book("1920348578", "Crafting with Cat Hair", "Tsuyana", "???"));
		repo.save(new Book("0011223456", "Harry Potter and the Sorcerer's Stone", "J.K.", "Rowling"));
		repo.save(new Book("0011223457", "Harry Potter and the Chamber of Secrets", "J.K.", "Rowling"));
		repo.save(new Book("0011223458", "Stuff and Things", "Craig", "Thompson"));
	}
	
}

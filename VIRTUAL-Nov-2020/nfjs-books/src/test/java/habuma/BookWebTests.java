package habuma;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BookWebTests {

	@LocalServerPort
	int port;
	
	@Autowired
	TestRestTemplate rest;
	
	@Autowired
	BookRepository bookRepo;
	
	@BeforeEach
	public void setup() {
		bookRepo.save(new Book("1234567890", "Test Book", "Test Author"));
		bookRepo.save(new Book("9876543210", "Test Book 2", "Test Author 2"));
	}
	
	@AfterEach
	public void cleared() {
		bookRepo.deleteAll();
	}
	
	@Test
	public void findById() {
		Book foundBook = rest.getForObject("/books/{id}", Book.class, 1);
		assertThat(foundBook.getIsbn()).isEqualTo("1234567890");
		assertThat(foundBook.getTitle()).isEqualTo("Test Book");
		assertThat(foundBook.getAuthor()).isEqualTo("Test Author");
		Book foundBook2 = rest.getForObject("/books/{id}", Book.class, 2);
		assertThat(foundBook2.getIsbn()).isEqualTo("9876543210");
		assertThat(foundBook2.getTitle()).isEqualTo("Test Book 2");
		assertThat(foundBook2.getAuthor()).isEqualTo("Test Author 2");
	}
	
	@Test
	public void findByIsbn() {
		Book foundBook = rest.getForObject("/books/isbn/{isbn}", Book.class, "1234567890");
		assertThat(foundBook.getIsbn()).isEqualTo("1234567890");
		assertThat(foundBook.getTitle()).isEqualTo("Test Book");
		assertThat(foundBook.getAuthor()).isEqualTo("Test Author");		
	}
	
}

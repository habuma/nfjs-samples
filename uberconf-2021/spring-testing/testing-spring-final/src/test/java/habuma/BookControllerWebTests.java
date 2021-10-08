package habuma;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BookControllerWebTests {

	@Autowired
	TestRestTemplate rest;
	
	@Test
	public void testGet() {
		Book[] books = rest.getForObject("/books", Book[].class);
		assertThat(books.length).isEqualTo(2);
	}
	
	@Test
	public void testGetByIsbn() {
		Book book = rest.getForObject("/books/{isbn}", Book.class, "1234567890");
		assertThat(book.getId()).isEqualTo(1L);
		assertThat(book.getIsbn()).isEqualTo("1234567890");
		assertThat(book.getTitle()).isEqualTo("Knitting with Dog Hair");
		assertThat(book.getAuthor()).isEqualTo("Kendall Crolius");
	}
	
	@Test
	public void testSave() {
		Book bookToSave = new Book("1122334455", "Test Book", "Test Author");
		Book savedBook = rest.postForObject("/books", bookToSave, Book.class);
		assertThat(savedBook).isNotNull();
		assertThat(savedBook.getId()).isNotNull();
	}
	
}

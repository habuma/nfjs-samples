package habuma;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class BookRepositoryTests {

	@Autowired
	BookRepository bookRepo;
	
	private Book savedBook;
	 
	@BeforeEach
	public void setup() {
		Book book = new Book("1234567890", "Test Book", "Test Author");
		this.savedBook = bookRepo.save(book);
	}
	
	@Test
	public void testFindByIsbn() {
		Book foundBook = bookRepo.findByIsbn("1234567890");
		assertThat(foundBook.getId()).isNotNull();
		assertThat(foundBook.getIsbn()).isEqualTo("1234567890");
		assertThat(foundBook.getTitle()).isEqualTo("Test Book");
		assertThat(foundBook.getAuthor()).isEqualTo("Test Author");
	}
	
}

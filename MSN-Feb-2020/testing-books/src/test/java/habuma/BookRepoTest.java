package habuma;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class BookRepoTest {

	@Autowired
	BookRepository bookRepo;
	
	private Book savedBook;
	
	@BeforeEach
	public void setup() {
		Book book = new Book("1234567890", "Test Book", "Test Author");
		this.savedBook = bookRepo.save(book);
	}
	
	@Test
	public void testSave() {
		assertThat(savedBook.getIsbn()).isEqualTo("1234567890");
		assertThat(savedBook.getTitle()).isEqualTo("Test Book");
		assertThat(savedBook.getAuthor()).isEqualTo("Test Author");
	}
	
	@Test
	public void findByIsbn() {
		Book isbnBook = bookRepo.findByIsbn("1234567890");
		assertThat(isbnBook.getIsbn()).isEqualTo("1234567890");
		assertThat(isbnBook.getTitle()).isEqualTo("Test Book");
		assertThat(isbnBook.getAuthor()).isEqualTo("Test Author");
	}
	
}

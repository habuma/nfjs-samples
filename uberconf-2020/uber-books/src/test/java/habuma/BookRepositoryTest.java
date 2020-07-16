package habuma;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class BookRepositoryTest {

	@Autowired
	BookRepository bookRepo;
	
	private Book savedBook;
	
	@BeforeEach
	public void saveAnInitialBook() {
		Book book = new Book("1234567890", "Test Book", "Test Author");
		this.savedBook = bookRepo.save(book);
	}
	
	@Test
	public void testSave() {
//		assertThat(savedBook.getId()).isEqualTo(1L);
		assertThat(savedBook.getIsbn()).isEqualTo("1234567890");
		assertThat(savedBook.getTitle()).isEqualTo("Test Book");
		assertThat(savedBook.getAuthor()).isEqualTo("Test Author");
	}
	
	@Test
	public void findBookByIsbn() {
		Book foundBook = bookRepo.findByIsbn("1234567890");
		assertThat(foundBook.getIsbn()).isEqualTo("1234567890");
		assertThat(foundBook.getTitle()).isEqualTo("Test Book");
		assertThat(foundBook.getAuthor()).isEqualTo("Test Author");		
	}
}

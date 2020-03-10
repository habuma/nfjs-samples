package habuma.tacos;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest(showSql = true)
public class BookRepositoryTests {

	@Autowired
	BookRepository repo;
	
	@BeforeEach
	public void saveABook() {
		Book savedBook = repo.save(new Book("1234567890", "Test Book", "Test Author"));
		assertThat(savedBook.getId()).isNotNull();
		assertThat(savedBook.getIsbn()).isEqualTo("1234567890");
		assertThat(savedBook.getTitle()).isEqualTo("Test Book");
		assertThat(savedBook.getAuthor()).isEqualTo("Test Author");
	}
	
	@Test
	public void fetchABook() {
		Book foundByIsbn = repo.findByIsbn("1234567890");
		assertThat(foundByIsbn.getId()).isNotNull();
		assertThat(foundByIsbn.getIsbn()).isEqualTo("1234567890");
		assertThat(foundByIsbn.getTitle()).isEqualTo("Test Book");
		assertThat(foundByIsbn.getAuthor()).isEqualTo("Test Author");
	}
	
}

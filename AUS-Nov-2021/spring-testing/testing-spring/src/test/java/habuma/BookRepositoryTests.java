package habuma;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.ActiveProfiles;

@DataJpaTest
@ActiveProfiles("testing")
public class BookRepositoryTests {

	@Autowired
	BookRepository repo;
	
	@Test
	public void testSomething() {
		Book foundBook = repo.findByIsbn("1234567890");
		assertThat(foundBook.getAuthor()).isEqualTo("Kendall Crolius");
		assertThat(foundBook.getTitle()).isEqualTo("Knitting with Dog Hair");
		assertThat(foundBook.getIsbn()).isEqualTo("1234567890");
	}
	
}

package habuma;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class BookRepositoryTests {

	@Autowired
	BookRepository repo;
	
	@Test
	public void testSave() {
		assertThat(repo.count()).isEqualTo(2);
		Book savedBook = repo.save(new Book("1122334455", "Test Book", "Test Author"));
		assertThat(savedBook.getId()).isNotNull();
		assertThat(repo.count()).isEqualTo(3);		
	}
	
	@Test
	public void testDelete() {
		assertThat(repo.count()).isEqualTo(2);
		repo.deleteById(1L);
		assertThat(repo.count()).isEqualTo(1);
	}
	
	@Test
	public void testFindByIsbn() {
		Book book = repo.findByIsbn("1234567890");
		assertThat(book.getIsbn()).isEqualTo("1234567890");
		assertThat(book.getTitle()).isEqualTo("Knitting with Dog Hair");
		assertThat(book.getAuthor()).isEqualTo("Kendall Crolius");
	}
	
	@Test
	public void testFindByAuthor() {
		Iterable<Book> books = repo.findByAuthor("Kaori Tsutaya");
		List<Book> bookList = 
				  StreamSupport.stream(books.spliterator(), false)
				    .collect(Collectors.toList());
		assertThat(bookList.size()).isEqualTo(1);
		Book book = bookList.get(0);
		assertThat(book.getIsbn()).isEqualTo("9876543210");
		assertThat(book.getTitle()).isEqualTo("Crafting with Cat Hair");
		assertThat(book.getAuthor()).isEqualTo("Kaori Tsutaya");		
	}
	
}

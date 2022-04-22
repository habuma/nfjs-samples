package habuma;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(controllers = BookController.class)
public class BookControllerMvcTests {
	
	@Autowired
	MockMvc mvc;
	
	@MockBean
	BookRepository repo;

	@Test
	public void whenPerformingGetRequestForBook() throws Exception {
		Book testBook = new Book("1234567890", "TEST BOOK", "TEST AUTHOR");
		when(repo.findByIsbn("1234567890")).thenReturn(testBook);
		
		mvc.perform(get("/books/1234567890"))
			.andExpect(jsonPath("isbn").value("1234567890"))
			.andExpect(jsonPath("title").value("TEST BOOK"))
			.andExpect(jsonPath("author").value("TEST AUTHOR"))
			;
	}
	
	@Test
	public void whenPerformingGetInvalidRequestForBook() throws Exception {
		Book testBook = new Book("1234567890", "TEST BOOK", "TEST AUTHOR");
		when(repo.findByIsbn("1234567890")).thenReturn(testBook);
		
		mvc.perform(get("/book/1234567890"))
			.andExpect(status().isNotFound());
	}
	
}

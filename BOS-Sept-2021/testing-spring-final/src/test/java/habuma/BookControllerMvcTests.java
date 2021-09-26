package habuma;

import static org.mockito.Mockito.when;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebMvcTest
@ExtendWith(RestDocumentationExtension.class)
public class BookControllerMvcTests {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	BookRepository bookRepo;

	@Autowired
	private WebApplicationContext context;

	@BeforeEach
	public void setUp(RestDocumentationContextProvider restDocumentation) {
		this.mockMvc = MockMvcBuilders
				.webAppContextSetup(context)
				.apply(documentationConfiguration(restDocumentation))
				.build();
	}

	@Test
	public void testGetByIsbn() throws Exception {
		Book testBook = new Book("1122334455", "Test Book", "Test Author");
		testBook.setId(1L);
		when(bookRepo.findByIsbn("1122334455")).thenReturn(testBook);

		mockMvc.perform(get("/books/{id}", "1122334455"))
				.andExpect(jsonPath("id").value(1L)).andExpect(jsonPath("isbn").value("1122334455"))
				.andExpect(jsonPath("title").value("Test Book")).andExpect(jsonPath("author").value("Test Author"))
				.andDo(document("sample"));
	}

}

package habuma;

import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.nio.charset.Charset;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.Resource;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.util.StreamUtils;

import io.micrometer.core.instrument.MeterRegistry;

@WebMvcTest(controllers=BookController.class)
public class BookCTests {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	BookRepository bookRepo;
	
	@MockBean
	MeterRegistry meterRegistry;
	
	@Value("classpath:/habuma/book.json")
	Resource bookJson;
	
	@Test
	@WithMockUser(username = "dummy", password="password", roles={"USER", "ADMIN"})
	public void testSavesABook() throws Exception {
		Book bookToSave = new Book("1234567890", "Test Book", "Test Author");
		Book savedBook = new Book("1234567890", "Test Book", "Test Author");
		savedBook.setId(1L);
		
		Mockito.when(bookRepo.save(bookToSave))
			.thenReturn(savedBook);
		
		mockMvc.perform(post("/books")
				.contentType(APPLICATION_JSON)
				.content(getBookJsonAsString()))
			.andExpect(status().isOk())
			.andExpect(jsonPath("id").value(1L))
			.andExpect(jsonPath("isbn").value("1234567890"))
			.andExpect(jsonPath("title").value("Test Book"))
			.andExpect(jsonPath("author").value("Test Author"));

		verify(bookRepo, only()).save(bookToSave);
	}
	
	@Test
	@WithMockUser(username="username", password="password", roles={"USER"})
	public void testSavesABook_UnauthorizedUser() throws Exception {
		mockMvc.perform(post("/books")
				.contentType(APPLICATION_JSON)
				.content(getBookJsonAsString()))
			.andExpect(status().isForbidden());

		verifyNoInteractions(bookRepo);
	}
	
	@Test
	@WithAnonymousUser
	public void testSavesABook_AnonymousUser() throws Exception {
		mockMvc.perform(post("/books")
				.contentType(APPLICATION_JSON)
				.content(getBookJsonAsString()))
			.andExpect(status().isUnauthorized());

		verifyNoInteractions(bookRepo);
	}
	
	private String getBookJsonAsString() throws IOException {
		return StreamUtils.copyToString(bookJson.getInputStream(), Charset.defaultCharset());
	}
}
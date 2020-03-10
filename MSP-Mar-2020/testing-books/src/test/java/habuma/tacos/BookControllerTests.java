package habuma.tacos;

import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.nio.charset.Charset;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.util.StreamUtils;

@WebMvcTest(controllers = BookController.class)
public class BookControllerTests {

	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	BookRepository mockRepo;
	
	
	@Value("classpath:/book.json")
	private Resource bookJson;

	@BeforeEach
	public void setupMocks() throws Exception {
		Book savedBook = new Book("1234567890", "Test Book", "Test Author");
		savedBook.setId(100L);
		when(mockRepo.save(new Book("1234567890", "Test Book", "Test Author")))
			.thenReturn(savedBook);
	}
	
	@Test
	@WithMockUser(username = "testuser", 
    			  password = "password", 
    			  roles = {"ADMIN", "USER"})
	public void testSaveABook() throws Exception {
		mockMvc.perform(MockMvcRequestBuilders.post("/books")
				.contentType(MediaType.APPLICATION_JSON)
				.content(getBookJsonAsString()))
			.andExpect(MockMvcResultMatchers.status().isCreated())
			.andExpect(MockMvcResultMatchers.jsonPath("isbn").value("1234567890"))
			.andExpect(MockMvcResultMatchers.jsonPath("title").value("Test Book"))
			.andExpect(MockMvcResultMatchers.jsonPath("author").value("Test Author"));
		
		verify(mockRepo, only()).save(new Book("1234567890", "Test Book", "Test Author"));
	}
	
	private String getBookJsonAsString() throws IOException {
		return StreamUtils.copyToString(bookJson.getInputStream(), 
				Charset.defaultCharset());
	}
}

package habuma;

import static org.mockito.Mockito.never;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

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

@WebMvcTest(controllers = BookController.class)
public class BookControllerTests {

	@Autowired
	MockMvc mockMvc;
	
	@Value("classpath:/testbook.json")
	Resource bookResource;
	
	@MockBean
	BookRepository mockRepo;

	@Test
	@WithMockUser(username="admin", password="password", roles={"USER", "ADMIN"})
	public void testSavesABook() throws Exception {
		
		
		Book bookToSave = new Book("1234567890", "Test Book", "Test Author");
		Book savedBook = new Book("1234567890", "Test Book", "Test Author");
		savedBook.setId(100L);
		
		Mockito.when(mockRepo.save(bookToSave))
			.thenReturn(savedBook);
		
		mockMvc.perform(post("/books")
				.contentType(APPLICATION_JSON)
				.content(resourceToJsonString(bookResource)))
			.andExpect(status().isCreated())
			.andExpect(jsonPath("id").value(100L))
			.andExpect(jsonPath("isbn").value("1234567890"))
			.andExpect(jsonPath("title").value("Test Book"))
			.andExpect(jsonPath("author").value("Test Author"));
		
		verify(mockRepo,only()).save(bookToSave);
	}
	
	@Test
	@WithMockUser(username="admin", password="password", roles={"USER"})
	public void testSavesABook_notadmin() throws Exception {
		Book bookToSave = new Book("1234567890", "Test Book", "Test Author");
		Book savedBook = new Book("1234567890", "Test Book", "Test Author");
		savedBook.setId(100L);
		
		Mockito.when(mockRepo.save(bookToSave))
			.thenReturn(savedBook);
		
		mockMvc.perform(post("/books")
				.contentType(APPLICATION_JSON)
				.content(resourceToJsonString(bookResource)))
			.andExpect(status().isForbidden());
		
		verify(mockRepo,never()).save(bookToSave);
	}
	
	@Test
	@WithAnonymousUser
	public void testSavesABook_notauthenticated() throws Exception {
		
		
		Book bookToSave = new Book("1234567890", "Test Book", "Test Author");
		Book savedBook = new Book("1234567890", "Test Book", "Test Author");
		savedBook.setId(100L);
		
		Mockito.when(mockRepo.save(bookToSave))
			.thenReturn(savedBook);
		
		mockMvc.perform(post("/books")
				.contentType(APPLICATION_JSON)
				.content(resourceToJsonString(bookResource)))
			.andExpect(status().isUnauthorized());
		
		verify(mockRepo,never()).save(bookToSave);
	}
	
	private String resourceToJsonString(Resource resource) throws Exception{
		return StreamUtils.copyToString(
				resource.getInputStream(), Charset.defaultCharset());
	}
	
}

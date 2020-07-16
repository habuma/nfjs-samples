package habuma;

import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.web.FilterChainProxy;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

@WebMvcTest(controllers = { HelloRestController.class, BooksController.class})
@ExtendWith(RestDocumentationExtension.class)
public class HelloRestTest {

	@MockBean
	BookRepository bookRepo;
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	WebApplicationContext context;
	
	//
	// Post-session fixes: To fix the @WithMockUser problem, see the items below
	// with comments that say "fixes-mock-user"
	//
	
	@BeforeEach
	public void setup(RestDocumentationContextProvider restDocumentation) {
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
				.apply(documentationConfiguration(restDocumentation))
				.apply(springSecurity()) // fixes-mock-user
				.build();
	}
	
	@Test
	@WithMockUser(username="habuma", password="password", roles= {"USER"})
	public void testHello() throws Exception {
		mockMvc.perform(get("/hellorest"))
			.andExpect(content().string("Hello world!"));
	}
	
	@Test
	@WithMockUser(username="habuma", password="password", roles= {"USER"})
	public void testSaveBook() throws Exception {
		Book bookToSave = new Book("1234567890", "Test Book", "Test Smith");
		Book savedBook = new Book("1234567890", "Test Book", "Test Smith");
		savedBook.setId(1L);
		
		Mockito.when(bookRepo.save(bookToSave))
			.thenReturn(savedBook);
		
		mockMvc.perform(post("/books")
				.with(csrf())   // fixes-mock-user
				.contentType(MediaType.APPLICATION_JSON)
				.content("{\"isbn\":\"1234567890\", \"title\":\"Test Book\", \"author\":\"Test Smith\"}"))
			.andExpect(jsonPath("id").value(1L))
			.andExpect(jsonPath("isbn").value("1234567890"))
			.andDo(document("books"));
	}
	
	
}

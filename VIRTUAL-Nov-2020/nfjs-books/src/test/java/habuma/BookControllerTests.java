package habuma;

import static org.mockito.Mockito.verifyNoInteractions;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document;
import static org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.documentationConfiguration;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.export.simple.SimpleMetricsExportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.restdocs.RestDocumentationContextProvider;
import org.springframework.restdocs.RestDocumentationExtension;
import org.springframework.security.config.annotation.SecurityConfigurer;
import org.springframework.security.test.context.support.WithAnonymousUser;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.util.StreamUtils;
import org.springframework.web.context.WebApplicationContext;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.config.MeterRegistryConfig;

@WebMvcTest(controllers=BookController.class)
@ExtendWith(RestDocumentationExtension.class)
public class BookControllerTests {

	@MockBean
	BookRepository bookRepo;
	
	@MockBean
	MeterRegistry meterRegistry;
	
	@Autowired
	MockMvc mockMvc;
	
	@Autowired
	WebApplicationContext context;
	
	@Value("classpath:/habuma/book.json")
	Resource bookJson;
	
	@BeforeEach
	public void setup(RestDocumentationContextProvider restDocumentation) throws Exception {
		// Configure the RestDocs configuration with MockMvc. Also, configure Spring Security configuration.
		// Normally, Spring Security configuration is automatically configured with MockMvc, but since this
		// method creates a new MockMvc setup from scratch, we have to also explicitly configure Spring
		// Security with MockMvc.
		this.mockMvc = MockMvcBuilders.webAppContextSetup(context)
				.apply(documentationConfiguration(restDocumentation))
				.apply(SecurityMockMvcConfigurers.springSecurity()) 
				.build();
	}
	
	@Test
	public void testGetBook() throws Exception {
		
		Book testBook = new Book("1234567890", "Test Book", "Test Author");
		testBook.setId(123L);
		Mockito.when(bookRepo.findById(123L)).thenReturn(Optional.of(testBook));
		
		mockMvc.perform(get("/books/{id}", 123L)
					.contentType(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("id").value(123L))
				.andExpect(jsonPath("isbn").value("1234567890"))
				.andExpect(jsonPath("title").value("Test Book"))
				.andExpect(jsonPath("author").value("Test Author"))
				.andExpect(status().isOk())
				.andDo(document("sample"));
		
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
	
	private String getBookJsonAsString() throws IOException {
		return StreamUtils.copyToString(bookJson.getInputStream(), Charset.defaultCharset());
	}
}

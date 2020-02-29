package habuma;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;
import java.nio.charset.Charset;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StreamUtils;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BookWebTests {

	@Autowired
	TestRestTemplate rest;
	
	@Autowired
	BookRepository bookRepo;
	
	@Value("classpath:/testbook.json")
	Resource bookJsonResource;
	
	@Test
	public void saveABook() throws Exception {
		String bookJson = resourceToJsonString(bookJsonResource);
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setBasicAuth("mickey", "password");
		RequestEntity<String> requestEntity = 
				new RequestEntity<String>(
						bookJson, headers, 
						HttpMethod.POST, URI.create("/books"));
		ResponseEntity<Book> responseEntity = rest.exchange(requestEntity, Book.class);
		assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		Book savedBookResponse = responseEntity.getBody();
		Long savedBookId = savedBookResponse.getId();
		assertThat(savedBookId).isNotNull();
		
		Book fetchedBook = bookRepo.findById(savedBookId).get();
		assertThat(fetchedBook).isNotNull();
		assertThat(fetchedBook.getIsbn()).isEqualTo("1234567890");
		assertThat(fetchedBook.getTitle()).isEqualTo("Test Book");
		assertThat(fetchedBook.getAuthor()).isEqualTo("Test Author");
	}
	
	private String resourceToJsonString(Resource resource) throws Exception{
		return StreamUtils.copyToString(
				resource.getInputStream(), Charset.defaultCharset());
	}
	
}

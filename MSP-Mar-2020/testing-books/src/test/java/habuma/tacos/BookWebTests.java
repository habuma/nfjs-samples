package habuma.tacos;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.net.URI;
import java.nio.charset.Charset;
import java.util.List;

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
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.util.StreamUtils;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BookWebTests {
	@Value("classpath:/book.json")
	private Resource bookJson;
	
	@Autowired
	TestRestTemplate rest;
	
	@Autowired
	BookRepository repo;
	
	@Test
	public void testPostABook() throws Exception {
		assertThat(repo.count()).isEqualTo(0);
		
		String bookJson = getBookJsonAsString();
		
		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth("habuma", "password");
		headers.setContentType(MediaType.APPLICATION_JSON);
		RequestEntity<String> requestEntity = new RequestEntity<String>(
				bookJson, headers,
				HttpMethod.POST, URI.create("/books"));
		ResponseEntity<Book> exchange = rest.exchange(requestEntity, Book.class);
		Book savedBook = exchange.getBody();
		
		assertThat(exchange.getStatusCode()).isEqualTo(HttpStatus.CREATED);
		
		assertThat(savedBook.getId()).isNotNull();
		assertThat(savedBook.getIsbn()).isEqualTo("1234567890");
		assertThat(savedBook.getTitle()).isEqualTo("Test Book");
		assertThat(savedBook.getAuthor()).isEqualTo("Test Author");
		
		List<Book> books = rest.getForObject("/books", List.class);
		assertThat(books.size()).isEqualTo(1);
		
		assertThat(repo.count()).isEqualTo(1);
	}
	
	private String getBookJsonAsString() throws IOException {
		return StreamUtils.copyToString(bookJson.getInputStream(), 
				Charset.defaultCharset());
	}
	
}

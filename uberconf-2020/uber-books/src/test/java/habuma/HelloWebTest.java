package habuma;

import static org.assertj.core.api.Assertions.assertThat;

import java.net.URI;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.RequestEntity;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class HelloWebTest {
	
	@Autowired
	TestRestTemplate rest;
	
	@Test
	public void saysHelloToGetRequest() {
		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth("habuma", "password");
		RequestEntity<Void> requestEntity = new RequestEntity<Void>(headers, HttpMethod.GET, URI.create("/hellorest"));
		String response = rest.exchange(requestEntity, String.class).getBody();
		assertThat(response).isEqualTo("Hello world!");
	}
	
// 
// Post-session TODO: I still need to fix this test...will look at it later.
//
//	@Test
	public void saveABook() {
		Book bookToSave = new Book("1234567890", "Fake Book", "Phony Smith");
		HttpHeaders headers = new HttpHeaders();
		headers.setBasicAuth("habuma", "password");
		RequestEntity<Book> requestEntity = new RequestEntity<Book>(bookToSave, headers, HttpMethod.POST, URI.create("/books"));
		Book savedBook = rest.exchange(requestEntity, Book.class).getBody();
		assertThat(savedBook.getId()).isNotNull();
	}
	
}

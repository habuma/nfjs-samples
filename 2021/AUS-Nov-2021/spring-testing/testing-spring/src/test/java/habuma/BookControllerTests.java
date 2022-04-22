package habuma;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.client.RestTemplate;

@ActiveProfiles("testing")
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class BookControllerTests {
	
	@Autowired
	TestRestTemplate rest;
	
	@Test
	public void testStuff() {
		Book foundBook = rest.getForObject(
				"/books/1234567890", 
				Book.class);
		assertThat(foundBook.getIsbn()).isEqualTo("1234567890");
		assertThat(foundBook.getTitle()).isEqualTo("Knitting with Dog Hair");
		assertThat(foundBook.getAuthor()).isEqualTo("Kendall Crolius");
	}
	
}

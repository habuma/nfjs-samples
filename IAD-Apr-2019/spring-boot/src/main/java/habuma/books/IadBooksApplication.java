package habuma.books;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class IadBooksApplication {

	public static void main(String[] args) {
		System.setProperty("spring.main.lazy-initialization", "true");
		System.setProperty("spring.jmx.enabled", "false");
		SpringApplication.run(IadBooksApplication.class, args);
	} 

}

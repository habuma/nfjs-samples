package habuma;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class ReactiveBooksClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveBooksClientApplication.class, args);
	}
	
	@Bean
	ApplicationRunner go() {
		return args -> {
			
			WebClient.create("http://localhost:8080")
				.get()
				.uri("/books")
				.retrieve()
				.bodyToFlux(Book.class)
				.doOnNext(book -> {
					System.err.println(" --> " + book.title());
				})
				.subscribe();
		};
	}

}

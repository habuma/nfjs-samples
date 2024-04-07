package habuma;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class BooksClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksClientApplication.class, args);
	}

	@Bean
	ApplicationRunner go(BookClient client) {
		return args -> {
//			WebClient
//				.create("http://localhost:8080")
//				.get()
//				.uri("/books")
//				.retrieve()
//				.bodyToFlux(Book.class)
//				.doOnNext(book -> {
//					System.err.println(
//							" --> " + book.isbn() + " ; " + book.title() + " by " + book.author());
//				})
//				.subscribe();
			
			client.getAllBooks()
					.doOnNext(book -> {
						System.err.println(
								" --> " + book.isbn() + " ; " + book.title() + " by " + book.author());
					})
					.subscribe();
		};
	}
	
}

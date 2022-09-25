package habuma;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class ReactiveBooksClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveBooksClientApplication.class, args);
	}
	
	@Bean
	public ApplicationRunner go() {
		return args -> {
			Mono<Book> bookMono = WebClient.create("http://localhost:8080")
				.get()
				.uri("/books/{isbn}", "1122334455")
				.retrieve()
				.bodyToMono(Book.class);
			
			bookMono
				.map(book -> {
					return new Book(book.id(), book.isbn(), book.title(), book.author().toUpperCase());
				})
				.doOnNext(book -> {
					System.out.println("BOOK: " + book.author());
				})
				.subscribe();
			
			
			Flux<Long> counterFlux = WebClient.create("http://localhost:8080")
					.get()
					.uri("/counter")
					.retrieve()
					.bodyToFlux(Long.class);
			
			counterFlux.subscribe(c -> {
				System.out.println("COUNT: " + c);
			});
			
		};
	}

}

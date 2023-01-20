package habuma;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class BooksClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksClientApplication.class, args);
	}
	
	@Bean
	public ApplicationRunner go() {
		return args -> {
			WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
			
			Flux<Book> bookFlux = webClient
				.get()
				.uri("/books")
				.exchangeToFlux(r -> {
					return r.bodyToFlux(Book.class);
				});
			
			bookFlux
				.doOnNext(b -> {
					System.out.println(b.getTitle() + " by " + b.getAuthor());
				}).subscribe();
			
		};
	}

}

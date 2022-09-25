package habuma;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class BooksClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksClientApplication.class, args);
	}
	
	@Bean
	public BookApi bookApi() throws Exception {
		WebClient client = WebClient.builder().build();
		HttpServiceProxyFactory factory = WebClientAdapter.createHttpServiceProxyFactory(client);
		factory.afterPropertiesSet();
		return factory.createClient(BookApi.class);
	}
	
	@Bean
	public ApplicationRunner go(BookApi api) {
		return args -> {
			Mono<Book> bookMono = WebClient.create("http://localhost:8080")
				.get()
				.uri("/books/{isbn}", "1122334455")
				.retrieve()
				.bodyToMono(Book.class);
			
			bookMono.subscribe( book -> {
				System.out.println("BOOK: " + book.title());
			});
			
			System.out.println("-----------------------------");
			
			api.bookByIsbn("5544332211")
				.subscribe(
						book -> {
							System.out.println("GOT A BOOK: " + book.title());
						}
						);
		};
	}

}

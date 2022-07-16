package habuma;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class ReactiveClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveClientApplication.class, args);
	}
	
	@Bean
	public ApplicationRunner go() {
		return args -> {
			Flux<Book> bookFlux = WebClient.create("http://localhost:8080")
				.get()
				.uri("/books")
				.retrieve()
				.bodyToFlux(Book.class);
			bookFlux
				.subscribe(b -> {
					System.out.println(" - " + b.getTitle());
				});
			
			Flux<CountItem> countFlux = WebClient.create("http://localhost:8080")
					.get()
					.uri("/count")
					.retrieve()
					.bodyToFlux(CountItem.class);
			countFlux.subscribe(c -> {
				System.out.println("COUNT: " + c.getCount());
			});
		};
	}

}

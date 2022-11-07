package habuma;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import reactor.core.publisher.Flux;

@SpringBootApplication
public class ReactiveBooksClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReactiveBooksClientApplication.class, args);
	}
	
	@Bean
	public BookClient bookClient() throws Exception {
		return httpServiceProxyFactory().createClient(BookClient.class);
	}
	
	private HttpServiceProxyFactory httpServiceProxyFactory() {
		WebClient webClient = WebClient.builder().build();
		WebClientAdapter client = WebClientAdapter.forClient(webClient);
		return HttpServiceProxyFactory.builder(client).build();
	}
	
	
	@Bean
	public ApplicationRunner go(BookClient bookClient) {
		return args -> {
			
			Book[] books = new RestTemplate().getForObject("http://localhost:8080/books", Book[].class);
			for (Book book : books) {
				System.out.println(" - " + book.title());
			}
			
//			WebClient.create("http://localhost:8080")
//				.get()
//				.uri("/books")
//				.header("SOME_HEADER", "SOME HEADER VALUE")
//				
//				.retrieve()
//				.bodyToFlux(Book.class)
//				.doOnNext(book -> {
//					System.out.println(" * " + book.title());
//				})
//				.subscribe();
			
			System.out.println("---------------------------------");
			
//			bookClient.save(new Book(null, "2233445566", "Spring in Action", "Craig Walls"))
//				.subscribe();
			
			Flux<Book> allBooks = bookClient.getAllBooks();
			allBooks.doOnNext(book -> {
					System.out.println(" !! " + book.title());
				})
				.subscribe();
			
		};
	}

}

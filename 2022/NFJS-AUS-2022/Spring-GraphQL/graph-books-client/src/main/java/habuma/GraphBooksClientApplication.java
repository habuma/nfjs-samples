package habuma;

import java.util.List;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.graphql.client.HttpGraphQlClient;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class GraphBooksClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(GraphBooksClientApplication.class, args);
	}
	
	@Bean
	public ApplicationRunner go() {
		return args -> {
			// ALERT: The reason that this didn't work toward the end of the
			//        GraphQL session at NFJS is because I wasn't thinking and
			//        added the Spring MVC dependency instead of the Spring
			//        WebFlux dependency. The GraphQL client wraps WebClient,
			//        which is only available via Spring WebFlux.
			
			HttpGraphQlClient graphQl = HttpGraphQlClient.builder()
					.webClient(c -> {
						c.baseUrl("http://localhost:8080/graphql");
					})
					.build();
			
			Mono<List<Book>> booksMono = graphQl.document("{allBooks{isbn title author{firstName lastName}}}")
				.retrieve("allBooks")
				.toEntityList(Book.class);
			
			booksMono
				.flatMapMany(bookList -> {
					return Flux.fromIterable(bookList);
				})
				.doOnNext(book -> {
						System.out.println("  -  " + book.getTitle());						
				})
				.subscribe();
		};
	}

}

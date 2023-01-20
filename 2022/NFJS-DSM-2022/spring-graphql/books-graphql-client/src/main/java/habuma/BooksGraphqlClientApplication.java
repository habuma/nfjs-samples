package habuma;

import java.util.List;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.graphql.client.GraphQlClient;
import org.springframework.graphql.client.GraphQlTransport;
import org.springframework.graphql.client.HttpGraphQlClient;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class BooksGraphqlClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksGraphqlClientApplication.class, args);
	}
	
	@Bean
	public ApplicationRunner go() {
		return args -> {
			HttpGraphQlClient qlClient = HttpGraphQlClient.builder()
				.webClient(c -> {
					c.baseUrl("http://localhost:8080/graphql");
				})
				.build();
			
			Mono<List<Book>> entityList = qlClient.document("{books{isbn title}}")
				.retrieve("books")
				.toEntityList(Book.class);
			
			entityList
				.subscribe(bl -> {
					for (Book book : bl) {
						System.out.println(book.getIsbn() + " ::  " + book.getTitle());
					}
				});
		};
	}

}

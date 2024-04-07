package habuma;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.graphql.client.HttpGraphQlClient;

import reactor.core.publisher.Mono;

@SpringBootApplication
public class BooksQlClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksQlClientApplication.class, args);
	}

	@Bean
	public ApplicationRunner go() {
		return args -> {
			
			HttpGraphQlClient graphQL = HttpGraphQlClient.builder()
					.webClient(c -> {
						c.baseUrl("http://localhost:8080/graphql");
					})
					.build();
			
			Mono<Greeting> response = graphQL.document("{hello{message}}")
				.retrieve("hello")
				.toEntity(Greeting.class);
			
			response
				.doOnNext(r -> {
					System.out.println("R: " + r.message());
				})
				.subscribe();
			
		};
	}
	
}

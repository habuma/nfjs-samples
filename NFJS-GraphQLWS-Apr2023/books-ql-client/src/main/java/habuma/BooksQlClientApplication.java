package habuma;

import java.util.List;

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
	ApplicationRunner go() {
	  return args -> {
	    HttpGraphQlClient graphQL = HttpGraphQlClient.builder()
	        .webClient(c -> {
	          c.baseUrl("http://localhost:8080/graphql");
	        })
	        .build();

	    Mono<String> helloMono = graphQL
	      .document("{hello}")
	      .retrieve("hello")
	      .toEntity(String.class);
	    helloMono
  	    .doOnNext(s -> {
  	      System.out.println(s);
  	    })
	      .subscribe();
	    
	    Mono<List<Book>> entityList = graphQL
	      .documentName("allBooks")
	      .retrieve("allBooks")
	      .toEntityList(Book.class);
	    
	    entityList
	      .doOnNext(bookList -> {
	        for (Book book : bookList) {
            System.out.println(" - " + book.getIsbn() +" : " + book.getTitle());
          }
	      })
	      .subscribe();
	  };
	  
	}
	
}

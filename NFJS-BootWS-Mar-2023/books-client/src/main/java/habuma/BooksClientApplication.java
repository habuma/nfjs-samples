package habuma;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

import io.micrometer.observation.ObservationRegistry;
import io.micrometer.observation.aop.ObservedAspect;

@SpringBootApplication
public class BooksClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksClientApplication.class, args);
	}
	
	@Bean
	ApplicationRunner go(BookClient client) {
	  return args -> {
//	    WebClient.create("http://localhost:8080")
//	      .get()
//	      .uri("/books")
//	      .retrieve()
//	      .bodyToFlux(Book.class)
//	      .doOnNext(book -> {
//	        System.out.println(" -- " + book.title() + " by " + book.author());
//	      })
//	      .subscribe();
	    
//	     WebClient.create("http://localhost:8080")
//         .get()
//         .uri("/books/{isbn}", "1122334455")
//         .retrieve()
//         .bodyToMono(Book.class)
//         .doOnNext(book -> {
//           System.out.println(" ** " + book.title() + " by " + book.author());
//         })
//         .subscribe();
	    
//	     Iterable<Book> booksList = WebClient.create("http://localhost:8080")
//         .get()
//         .uri("/books")
//         .retrieve()
//         .bodyToFlux(Book.class)
//         .toIterable();
//	     
//	     for (Book book : booksList) {
//        System.out.println(" ^^ " + book.title());
//      }
	    
	    client.getAllBooks()
	      .subscribe(book -> {
	        System.out.println(" ## " + book.title());
	      });
	    
	  };
	}
	
	@Bean
	HttpServiceProxyFactory httpServiceProxyFactory() {
	  WebClient webClient = WebClient.create();
	  WebClientAdapter webClientAdapter = WebClientAdapter.forClient(webClient);
	  return HttpServiceProxyFactory.builder(webClientAdapter).build();
	}
	
	@Bean
	BookClient bookClient(HttpServiceProxyFactory httpServiceProxyFactory) throws Exception {
	  return httpServiceProxyFactory.createClient(BookClient.class);
	}
	
}

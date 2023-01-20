package habuma;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

import reactor.core.publisher.Mono;

@HttpExchange(url="http://localhost:8080/books")
public interface BookApi {

	@GetExchange("/{isbn}")
	Mono<Book> bookByIsbn(@PathVariable("isbn") String isbn);
	
}

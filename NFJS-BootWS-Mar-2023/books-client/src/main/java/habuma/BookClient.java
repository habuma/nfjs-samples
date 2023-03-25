package habuma;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@HttpExchange(url = "http://localhost:8080/books")
public interface BookClient {

    @GetExchange
    Flux<Book> getAllBooks();
    
    @GetExchange("/{isbn}")
    Mono<Book> getBookByIsbn(@PathVariable("isbn") String isbn);
    
    @PostExchange
    Mono<Book> addBook(@RequestBody Book book);
  
}

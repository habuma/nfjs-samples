package habuma.booksclient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import org.springframework.web.service.annotation.PostExchange;
import reactor.core.publisher.Mono;

@HttpExchange(url="http://localhost:8080/books")
public interface BookApi {

    @GetExchange("/{isbn}")
    Mono<Book> findByIsbn(@PathVariable("isbn") String isbn);

    @PostExchange
    Mono<Book> addBook(@RequestBody Book book);

}

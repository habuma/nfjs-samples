package habuma.cmhbooksclient;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import reactor.core.publisher.Flux;

@HttpExchange(url="http://localhost:8080/books")
public interface BookApi {

    @GetExchange
    Flux<Book> getAllBooks();

}

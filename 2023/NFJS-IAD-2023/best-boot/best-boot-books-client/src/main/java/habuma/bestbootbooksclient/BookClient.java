package habuma.bestbootbooksclient;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange("http://localhost:8080/books")
public interface BookClient {

    @GetExchange("/{isbn}")
    Book findBookByIsbn(@PathVariable("isbn") String isbn);

}

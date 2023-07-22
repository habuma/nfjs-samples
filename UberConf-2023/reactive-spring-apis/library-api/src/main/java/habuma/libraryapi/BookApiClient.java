package habuma.libraryapi;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;

@HttpExchange(url="http://localhost:8080")
public interface BookApiClient {

    @GetExchange("/books/isbn/{isbn}")
    Book getBookByIsbn(@PathVariable("isbn") String isbn);

}

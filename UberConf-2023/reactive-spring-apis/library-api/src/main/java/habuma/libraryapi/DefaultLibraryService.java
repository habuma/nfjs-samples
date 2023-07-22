package habuma.libraryapi;

import io.micrometer.observation.annotation.Observed;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Observed
public class DefaultLibraryService implements LibraryService{


    private final WebClient webClient;

    public DefaultLibraryService(WebClient webClient) {
        this.webClient = webClient;
    }

    @Override
    public Mono<Book> getBookByIsbn(String isbn) {
        return webClient
                .get()
                .uri("http://localhost:8080/books/isbn/{isbn}", isbn)
                .retrieve()
                .bodyToMono(Book.class);
    }

}

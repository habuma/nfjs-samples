package habuma.libraryapi;

import reactor.core.publisher.Mono;

public interface LibraryService {

    Mono<Book> getBookByIsbn(String isbn);
}

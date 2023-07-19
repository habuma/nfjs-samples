package habuma.books;

public class UnknownBookException extends RuntimeException {

    private final String isbn;

    public UnknownBookException(String isbn) {
        super("Unknown book: " + isbn);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }
}

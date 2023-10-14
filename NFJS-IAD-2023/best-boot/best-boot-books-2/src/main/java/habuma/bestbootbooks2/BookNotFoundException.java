package habuma.bestbootbooks2;

public class BookNotFoundException extends RuntimeException {

    private String isbn;

    public BookNotFoundException() {}

    public BookNotFoundException(String isbn) {
        super("Book not found: " + isbn);
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }
}

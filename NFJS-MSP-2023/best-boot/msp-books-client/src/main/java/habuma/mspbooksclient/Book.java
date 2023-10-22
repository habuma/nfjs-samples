package habuma.mspbooksclient;

public record Book(
        Long id,
        String isbn,
        String title,
        String author) {
}

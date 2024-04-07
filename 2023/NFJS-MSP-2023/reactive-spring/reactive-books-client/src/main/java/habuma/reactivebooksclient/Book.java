package habuma.reactivebooksclient;

public record Book(
        Long id,
        String isbn,
        String title,
        String author) {
}

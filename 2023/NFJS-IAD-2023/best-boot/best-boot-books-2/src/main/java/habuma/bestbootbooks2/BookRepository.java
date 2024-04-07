package habuma.bestbootbooks2;

import org.springframework.jdbc.core.simple.JdbcClient;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepository {
    JdbcClient jdbc;

    public BookRepository(JdbcClient jdbc) {
    this.jdbc = jdbc;
    }

    public Iterable<Book> findAll() {
        return jdbc.sql("select id, isbn, title, author from book")
                .query(Book.class)
                .list();
    }

    public Book findByIsbn(String isbn) {
        return jdbc.sql("select id, isbn, title, author from book where isbn = :isbn")
                .param("isbn", isbn)
                .query(Book.class)
                .single();
    }

    public Book save(Book book) {
        int update = jdbc.sql("insert into book (isbn, title, author) values (:isbn, :title, :author)")
                .param("isbn", book.isbn())
                .param("title", book.title())
                .param("author", book.author())
                .update();
        if (update == 1) {
            return book;
        } else {
            throw new RuntimeException("Couldn't save book: " + book);
        }
    }

}

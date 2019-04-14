package habuma.books;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class JdbcBooksRepository 
	implements BooksRepository {

	private final JdbcTemplate jdbc;
	
	@Override
	public Iterable<Book> findAll() {
		
		return jdbc.query("select id, isbn, title, author from Books", 
				(rs, rownum) -> {
					return new Book(
							rs.getLong("id"),
							rs.getString("isbn"),
							rs.getString("title"),
							rs.getString("author")
							);
				});
	}

	@Override
	public Book save(Book b) {
		
		jdbc.update("insert into Books (id, isbn, title, author) values (?,?,?,?)",
				b.getId(), b.getIsbn(), b.getTitle(), b.getAuthor()
				);
		
		return b;
	}

	
}

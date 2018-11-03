package habuma;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class JdbcBookRepository 
	implements BookRepository {
	
	private final JdbcTemplate jdbc;

	@Override
	public Iterable<Book> findAll() {
		return jdbc.query("select isbn, title, author from Books order by isbn", 
				(rs, rowNum) -> {
					String isbn = rs.getString("isbn");
					String title = rs.getString("title");
					String author = rs.getString("author");
					return new Book(isbn, title, author);
				});
	}
	
	@Override
	public Book save(Book b) {
		return null;
	}
	
}

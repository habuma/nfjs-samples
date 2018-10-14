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
		return jdbc.query("select isbn, title, author from Books", 
				(rs, rowNum) -> {
					return new Book(rs.getString("isbn"), 
							rs.getString("title"), 
							rs.getString("author"));
				});
	}
	
}

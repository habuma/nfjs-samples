package habuma;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Repository
public class JdbcBookRepository 
	implements BookRepository {

	private final JdbcTemplate jdbc;
	
	@Override
	public Iterable<Book> findAll() {
		return jdbc.query("select isbn, title, author from books",
				(rs, rowNum) -> {
					return new Book(rs.getString("isbn"), 
							rs.getString("title"),
							rs.getString("author"));
				}
		);
	}
	
	@Override
	public Book save(Book book) {
		
		jdbc.update("insert into books (isbn, title, author) values (?,?,?)", 
				book.getIsbn(), book.getTitle(), book.getAuthor());
		
		return book;
	}
	
}

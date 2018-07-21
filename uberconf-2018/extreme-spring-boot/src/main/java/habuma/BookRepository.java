package habuma;

public interface BookRepository {

	Book save(Book book);
	
	Iterable<Book> findAll();
	
}

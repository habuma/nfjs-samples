package habuma;

public interface BookRepository {

	Book save(Book b);
	Iterable<Book> findAll();
	
}

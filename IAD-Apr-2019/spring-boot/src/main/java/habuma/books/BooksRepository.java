package habuma.books;

public interface BooksRepository {

	Iterable<Book> findAll();
	Book save(Book b);
	
}

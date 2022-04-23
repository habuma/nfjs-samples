package com.example.demo;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BooksQlController {
	
	private BookRepository repo;
	private AuthorRepository authorRepo;

	public BooksQlController(BookRepository repo, AuthorRepository authorRepo) {
		this.repo = repo;
		this.authorRepo = authorRepo;
	}

//	@QueryMapping(name="bookByIsbn")
//	public Book byIsbn(@Argument("isbn") String isbn) {
//		System.out.println("CALLING byIsbn()");
//		return repo.findByIsbn(isbn);
//	}
	
	@MutationMapping(name="createBook")
	public Book createABook(@Argument(name="input") BookInput book) {
		Author author = new Author(book.getAuthorFirstName(), book.getAuthorLastName());
		
		Author savedAuthor = authorRepo.save(author);
		Book newBook = new Book(book.getIsbn(), book.getTitle(), savedAuthor);
		
		return repo.save(newBook);
	}
	
}

package com.example.demo;

import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;

@Controller
public class BooksQlController {

	private BookRepository repo;
	private AuthorRepository aRepo;

	public BooksQlController(BookRepository repo, AuthorRepository aRepo) {
		this.repo = repo;
		this.aRepo = aRepo;
	}
	
	@MutationMapping("createBook")
	public Book createBook(@Argument("input") Book bookIn) {
		System.out.println("!!!!! SAVING");
		bookIn.setAuthor(aRepo.save(bookIn.getAuthor()));
		return repo.save(bookIn);
	}
	
//	@QueryMapping("books")
//	public Iterable<Book> books() {
//		return repo.findAll();
//	}
	
}

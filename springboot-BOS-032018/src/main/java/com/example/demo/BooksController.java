package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/books")
@RequiredArgsConstructor
@Slf4j
public class BooksController {
	
	private final BookRepository repo;
	private final GreetingProps props;
	
	@GetMapping
	public String books(Model model) {
		log.info("GETTING SOME BOOKS");
		model.addAttribute("greeting", props.getMessage());
		model.addAttribute("books", repo.findAll());
		return "booklist";
	}
	
	@PostMapping
	@ResponseBody
	public Book postABook(@RequestBody Book book) {
		return repo.save(book);
	}
	
}

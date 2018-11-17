package habuma;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/ui/books")
@RequiredArgsConstructor
public class BooksUiController {

	private final BookServiceImpl bookService;
	
	@GetMapping
	public String allTheBook(Model model) {
		model.addAttribute("books", bookService.allBooks());
		return "bookList";
	}
	
}

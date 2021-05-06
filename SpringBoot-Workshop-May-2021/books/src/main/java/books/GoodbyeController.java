package books;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GoodbyeController {

	@GetMapping("/goodbye")
	public String bye(Model model) {
		model.addAttribute("who", "World");
		return "bye";
	}
	
}

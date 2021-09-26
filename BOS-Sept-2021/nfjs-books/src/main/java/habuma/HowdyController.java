package habuma;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HowdyController {

	@GetMapping("/howdy")
	public String howdy(Model model) {
		model.addAttribute("message", "Howdy Boston!");
		return "howdy-view";
	}
	
	@GetMapping("/bye")
	@ResponseBody
	public String bye() {
		return "Goodbye";
	}
	
}

package habuma;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@GetMapping(path="/hello")
	public String hello(
			@RequestParam(name="who", defaultValue="World") String who,
			Model model) {
		
		model.addAttribute("who", who);
		
		return "hello-view";
	}
	
}

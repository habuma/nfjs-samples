package habuma;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GoodbyeController {

	@GetMapping("/bye")
	public String bye() {
		return "goodbye";
	}
	
}

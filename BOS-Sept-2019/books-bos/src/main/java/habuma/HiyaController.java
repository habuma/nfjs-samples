package habuma;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HiyaController {

	@GetMapping("/hi")
	public String hiya(Model model) {
		model.addAttribute("who", "Framingham");
		return "hiya";
	}
	
}

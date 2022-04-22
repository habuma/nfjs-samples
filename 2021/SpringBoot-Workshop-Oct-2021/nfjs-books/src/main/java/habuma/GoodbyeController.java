package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GoodbyeController {

	@GetMapping("/bye")
	public String bye() {
		return "Hasta la vista!!!!!!";
	}
	
}

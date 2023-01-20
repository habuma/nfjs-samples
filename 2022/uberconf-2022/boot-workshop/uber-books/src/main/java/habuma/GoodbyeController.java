package habuma;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GoodbyeController {
	
	private final UberProps props;
	
	public GoodbyeController(UberProps props) {
		this.props = props;
	}

	@GetMapping("/goodbye")
	public String goodbye(Model model) {
		model.addAttribute("where", props.getWhere());
		return "bye";
	}
	
}

package habuma;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	public HelloController(GreetingProps props) {
		this.props = props;
	}
	
	private final GreetingProps props;
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("who", props.getWho());
		return "helloView";
	}
	
}

package books;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {

	private static final Logger log = LoggerFactory.getLogger(HelloController.class);
	
	private GreetingProps props;

	public HelloController(GreetingProps props) {
		this.props = props;
	}
	
	@GetMapping("/hello")
	public String hello(Model model) {
		model.addAttribute("greeting", props.getMessage());
		log.debug("Saying hello!");
		return "hello-view";
	}
	
}

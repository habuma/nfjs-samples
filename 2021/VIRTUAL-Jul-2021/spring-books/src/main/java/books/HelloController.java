package books;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloController {
	
	GreetingProps props;
	
	public HelloController(GreetingProps props) {
		this.props = props;
	}

	@GetMapping(path="/hello")
	public String hello(Model model) {
		model.addAttribute("greeting", props.getMessage());
		return "hellopage";
	}
	
}

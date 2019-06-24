package habuma;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class HelloController {

	private final GreetingProps props;

	@GetMapping("/hello") 
	public String hello(Model model) {
		model.addAttribute("where", props.getWhere());
		return "hello-view";
	}
	
}

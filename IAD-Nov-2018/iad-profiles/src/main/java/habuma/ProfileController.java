package habuma;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/profiles")
@RequiredArgsConstructor
public class ProfileController {

	private final ProfileRepository repo;
	
	@GetMapping("/{username}")
	public String me(@PathVariable("username") String username, Model model) {
		model.addAttribute("profile", repo.findByUsername(username));
		return "profile";
	}
	
}

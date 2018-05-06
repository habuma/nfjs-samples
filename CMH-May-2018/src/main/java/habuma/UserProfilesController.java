package habuma;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/userProfiles")
@RequiredArgsConstructor
public class UserProfilesController {

	private final UserProfileRepository repo;
	
	@GetMapping
	public String all(Model model) {
		model.addAttribute("profiles", repo.findAll());
		return "profileList";
	}
	
}

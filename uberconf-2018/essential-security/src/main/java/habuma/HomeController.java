package habuma;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/me")
	@PreAuthorize("#{isAuthenticated() and hasRole('USER')}")
	public String userPage(@AuthenticationPrincipal AppUser appUser, Model model) {
		model.addAttribute("user", appUser.getFullname());
		return "userDetails";
	}
	
}

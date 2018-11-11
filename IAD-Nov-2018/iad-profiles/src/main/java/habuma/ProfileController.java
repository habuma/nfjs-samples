package habuma;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/profiles")
@RequiredArgsConstructor
public class ProfileController {
	
	@GetMapping("/me")
	public String me(@AuthenticationPrincipal Profile profile, Model model) {		
		model.addAttribute("profile", profile);
		return "profile";
	}
	
}

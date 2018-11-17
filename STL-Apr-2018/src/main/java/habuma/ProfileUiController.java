package habuma;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class ProfileUiController {
	
	@GetMapping("/ui/profiles/me")
	public String allProfiles(@AuthenticationPrincipal Profile profile, Model model) {
		model.addAttribute("profile", profile);
		return "profiles";
	}
	
}

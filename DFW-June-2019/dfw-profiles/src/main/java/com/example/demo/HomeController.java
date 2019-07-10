package com.example.demo;

import java.security.Principal;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

	@GetMapping("/home")
	public String home(Principal principal, Model model) {
		
		String name = principal.getName();
		model.addAttribute("who", name);
		return "homepage";
	}
	
}

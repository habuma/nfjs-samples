package habuma;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("/tacos")
@RequiredArgsConstructor
@Slf4j
public class TacoController {

	private final TacoRepository tacoRepo;
	
	@GetMapping
	public String allTacos(Model model) {
		model.addAttribute("tacos", tacoRepo.findAll());
		return "tacolist";
	}
	
	@GetMapping("/form")
	public String tacoForm() {
		return "tacoform";
	}
	
	@PostMapping
	public String saveATaco(Taco taco) {
		log.info("TACO:  " + taco);
		tacoRepo.save(taco);
		return "redirect:/tacos";
	}
	
}

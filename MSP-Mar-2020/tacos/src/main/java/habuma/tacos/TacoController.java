package habuma.tacos;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/tacos")
@RequiredArgsConstructor
public class TacoController {

	private final TacoRepository tacoRepo;
	
	@GetMapping
	public String tacoList(@RequestParam(name="wrap", required=false) String wrap, Model model) {
		
		if (wrap == null) {
			Iterable<Taco> tacos = tacoRepo.findAll();
			model.addAttribute("tacos", tacos);
		} else {
			Iterable<Taco> tacos = tacoRepo.findByWrap(wrap);
			model.addAttribute("tacos", tacos);
		}
		
		return "tacolist";
	}
	
}

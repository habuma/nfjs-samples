package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/who")
@Slf4j
public class WhoController {

	@GetMapping
	public String getWho() {
		log.info("Returning 'World'");
		return "World";
	}
	
}

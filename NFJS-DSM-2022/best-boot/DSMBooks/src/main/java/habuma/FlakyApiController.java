package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FlakyApiController {

	@GetMapping("/flaky")
	public String flaky() {
		double random = Math.random();
		if (random < 0.5) {
			throw new CrapHappenedException("The number was too low: " + random);
		}
		
		return "Everything's okay!";
	}
	
}

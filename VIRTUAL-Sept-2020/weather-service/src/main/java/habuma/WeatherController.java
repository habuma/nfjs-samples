package habuma;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
public class WeatherController {

	@GetMapping
	public String weather() {
		return "Cloudy and cool";
	}
	
	@GetMapping("/slow")
	public String slow() throws Exception {
		Thread.sleep(10000);
		return "SLOW";
	}
	
}

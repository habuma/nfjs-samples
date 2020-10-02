package habuma;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/weather")
@ConfigurationProperties(prefix="weather")
public class WeatherController {
	
	private String current;
	

	@GetMapping("/current")
	public String currentConditions() {
		return current;
	}
	
	@GetMapping("/slow")
	public String slow() throws Exception {
		Thread.sleep(10000);
		
		return "SLOW";
	}

	public String getCurrent() {
		return current;
	}

	public void setCurrent(String current) {
		this.current = current;
	}
	
}

package habuma;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class CounterController {

	@GetMapping(path="/count", produces = {MediaType.APPLICATION_STREAM_JSON_VALUE})
	public Flux<String> counter() {
		return Flux.interval(Duration.ofSeconds(1))
				.map(n -> "COUNT:  " + n);
	}
	
}

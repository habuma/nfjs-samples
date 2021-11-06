package streeteats;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class HelloController {

	private GreetingProps props;

	public HelloController(GreetingProps props) {
		this.props = props;
	}

	@GetMapping("/hello")
	public Mono<String> hello() {
		return Mono.just(props.getMessage())
				.map(in -> in.toUpperCase());
	}
	
}

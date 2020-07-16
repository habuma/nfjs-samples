package habuma;

import java.time.Duration;

import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import reactor.core.publisher.Flux;

@Controller
public class RSocketServer {
	@MessageMapping("book")
	Flux<String> handler(Book book) {
		System.out.println("GOT A BOOK!  :  " + book);
		return Flux.interval(Duration.ofSeconds(1))
				.map(i -> "Count : " + i);
	}
}

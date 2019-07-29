package habuma;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;

@RestController
public class StreamingController {

	@GetMapping(path="/stream",
			produces = MediaType.APPLICATION_STREAM_JSON_VALUE)
	public Flux<Thing> stream() {
		return Flux.interval(Duration.ofSeconds(1))
				.map(l -> new Thing(l, System.currentTimeMillis()));
	}
	
	private final class Thing {
		
		Thing(long l, long t) {
			this.l = l;
			this.t = t;
		}
		
		private final long l;
		private final long t;
		
		public long getL() {
			return l;
		}
		
		public long getT() {
			return t;
		}
	}
	
}

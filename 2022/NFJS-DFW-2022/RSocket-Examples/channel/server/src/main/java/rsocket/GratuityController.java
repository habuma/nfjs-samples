package rsocket;
import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import reactor.core.publisher.Flux;

@Controller
public class GratuityController {

	private static final Logger log = LoggerFactory.getLogger(GratuityController.class);

	@MessageMapping("gratuity")
	public Flux<GratuityOut> calculate(Flux<GratuityIn> gratuityInFlux) {
		return gratuityInFlux
			.doOnNext(in -> log.info("Calculating gratuity:  {}", in))
			.map(in -> {
				double percentAsDecimal = in.getPercent() / 100.0;
				BigDecimal gratuity = in.getBillTotal()
						.multiply(BigDecimal.valueOf(percentAsDecimal));
				return new GratuityOut(in.getBillTotal(), in.getPercent(), gratuity);
			});
	}

}

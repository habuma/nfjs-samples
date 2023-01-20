package rsocket;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.RSocketRequester;

@Configuration
public class RSocketClientConfiguration {

	private static final Logger log = LoggerFactory.getLogger(RSocketClientConfiguration.class);

	@Bean
	public ApplicationRunner sender(RSocketRequester.Builder requesterBuilder) {
		return args -> {
			String stockSymbol = "XYZ";

			RSocketRequester tcp = requesterBuilder.tcp("localhost", 7000);
			tcp
				.route("stock/{symbol}", stockSymbol)
				.retrieveFlux(StockQuote.class)
				.doOnNext(stockQuote ->
					log.info(
							"Price of {} : {} (at {})",
							stockQuote.getSymbol(),
							stockQuote.getPrice(),
							stockQuote.getTimestamp())
				)
				.subscribe();
		};
	}

}

package habuma;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.amqp.dsl.Amqp;
import org.springframework.integration.amqp.inbound.AmqpMessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;

@SpringBootApplication
public class TripProcessor {
	
	private static Logger log = LoggerFactory.getLogger(TripProcessor.class); 

	public static void main(String[] args) {
		SpringApplication.run(TripProcessor.class, args);
	}

	AtomicInteger total = new AtomicInteger();
	
	
	@Bean
	public IntegrationFlow flow(
			ConnectionFactory cf,
			AmqpTemplate amqpTemplate) {
		return IntegrationFlows
				.from(new AmqpMessageSource(cf, "trips"),
						c -> c.poller(Pollers.fixedRate(1000)))
				.<TripBooking, Itinerary> transform(trip -> {
						log.info("PROCESSING TRIP. Payment card: " + trip.getPaymentCardNumber());
						log.info("ITINERARY:  " + trip.getItinerary());
						return trip.getItinerary();
					})
				.handle(Amqp.outboundGateway(amqpTemplate).routingKey("itineraries").waitForConfirm(false))
				.get();
			
	}

}

package trips;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.amqp.dsl.Amqp;
import org.springframework.integration.amqp.inbound.AmqpMessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;

@SpringBootApplication
public class SiTripSinkApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiTripSinkApplication.class, args);
	}
	
	@Bean
	public IntegrationFlow flow(AmqpTemplate rabbit, ConnectionFactory cf) {
		return IntegrationFlows
				.from(new AmqpMessageSource(cf, "trips"))
				.handle(message -> {
					Itinerary itinerary = (Itinerary) message.getPayload();
					System.out.println("SI : BOOKING TRIP TO: " 
									+ itinerary.getDestination());
				})
				.get();
	}	

}

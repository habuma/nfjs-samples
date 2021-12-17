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
public class SiTripProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiTripProcessorApplication.class, args);
	}

	@Bean
	public IntegrationFlow flow(AmqpTemplate rabbit, ConnectionFactory cf) {
		return IntegrationFlows
				.from(new AmqpMessageSource(cf, "itineraries"))
				.<Itinerary, Itinerary> transform(itinerary -> {
					System.out.println("SI : PROCESSING PAYMENT: " 
									+ itinerary.getPaymentCardNumber());
					return itinerary;
				})
				.handle(Amqp.outboundGateway(rabbit)
						.routingKey("trips").waitForConfirm(false))
				.get();
	}

}

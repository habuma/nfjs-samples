package habuma;

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
public class SiTripProcessorApplication {
  
  private static final Logger log = LoggerFactory.getLogger(SiTripProcessorApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SiTripProcessorApplication.class, args);
	}
	
	@Bean
	public IntegrationFlow flow(ConnectionFactory cf, AmqpTemplate amqpTemplate) {
	  return IntegrationFlows
	          .from(new AmqpMessageSource(cf, "trips"), 
	              c -> c.poller(Pollers.fixedRate(1000)))
	          .<TripBooking, Itinerary> transform(trip -> {
	            log.info("PROCESSING TRIP:  Payment card number: " + trip.getPaymentCardNumber());
	            return trip.getItinerary();
	          })
	          .handle(Amqp.outboundGateway(amqpTemplate).routingKey("itineraries"))
	          .get();
	}
	

}

package habuma;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.amqp.inbound.AmqpMessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;

@SpringBootApplication
public class SiTripSinkApplication {

  private static final Logger log = LoggerFactory.getLogger(SiTripSinkApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SiTripSinkApplication.class, args);
	}

	@Bean
	public IntegrationFlow flow(ConnectionFactory cf) {
	  return IntegrationFlows
	      .from(new AmqpMessageSource(cf, "itineraries"),
	            c -> c.poller(Pollers.fixedRate(1000)))
	      
	      .<Itinerary>handle(itinerary -> {
	        log.info("SCHEDULING ITINERARY:  " + itinerary);
	      })
	      
	      .get();
	}
	
}

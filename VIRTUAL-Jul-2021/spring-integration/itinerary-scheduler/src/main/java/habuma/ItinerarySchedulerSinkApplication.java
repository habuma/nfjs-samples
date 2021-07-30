package habuma;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.amqp.inbound.AmqpMessageSource;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.dsl.Pollers;

@SpringBootApplication
public class ItinerarySchedulerSinkApplication {
	
	private static Logger log = LoggerFactory.getLogger(ItinerarySchedulerSinkApplication.class); 

	public static void main(String[] args) {
		SpringApplication.run(ItinerarySchedulerSinkApplication.class, args);
	}
	
  @Bean
  public IntegrationFlow flow(ConnectionFactory connectionFactory, AmqpTemplate amqpTemplate) {
    return IntegrationFlows
        .from(new AmqpMessageSource(connectionFactory, "itineraries"), 
            c -> c.poller(Pollers.fixedRate(1000)))
        .handle(itinerary -> {
          log.info("SCHEDULING ITINERARY:  " + itinerary);
        })
        .get();
  }

}

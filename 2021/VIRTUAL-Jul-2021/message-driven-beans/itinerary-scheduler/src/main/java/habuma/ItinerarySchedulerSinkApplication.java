package habuma;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ItinerarySchedulerSinkApplication {
	
	private static Logger log = LoggerFactory.getLogger(ItinerarySchedulerSinkApplication.class); 

	public static void main(String[] args) {
		SpringApplication.run(ItinerarySchedulerSinkApplication.class, args);
	}
	
	@RabbitListener(queues = "itineraries")
	public void scheduleItinerary(Itinerary itinerary) {
		log.info("SCHEDULING ITINERARY:  " + itinerary);
	}

}

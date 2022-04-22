package trips;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class ItinerarySink {
	@RabbitListener(queues = "trips")
	public void handleItinerary(Itinerary itinerary) {
		System.out.println("BOOKING AN ITINERARY:  " + 
					itinerary.getDestination());
	}
}

package trips;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class ItineraryProcessor {
	@RabbitListener(queues = "itineraries")
	@SendTo("trips")
	public Itinerary handleItinerary(Itinerary itinerary) {
		System.out.println("PROCESS PAYMENT:  " + 
					itinerary.getPaymentCardNumber());
		return itinerary;
	}
}

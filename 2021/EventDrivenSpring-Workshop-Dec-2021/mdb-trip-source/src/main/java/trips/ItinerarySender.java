package trips;

import java.util.Date;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ItinerarySender {

	private RabbitTemplate rabbit;

	public ItinerarySender(RabbitTemplate rabbit) {
		this.rabbit = rabbit;
	}
	
	@Scheduled(fixedRate = 3000)
	public void send() {
		Itinerary itinerary = new Itinerary(
				"Paris", "4111111111111111", new Date(), new Date());
		rabbit.convertAndSend("itineraries", itinerary);
	}
	
}

package habuma;

import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.messaging.handler.annotation.SendTo;

@SpringBootApplication
public class TripProcessor {
	
	private static Logger log = LoggerFactory.getLogger(TripProcessor.class); 

	public static void main(String[] args) {
	    System.setProperty("spring.devtools.restart.enabled", "false");

		SpringApplication.run(TripProcessor.class, args);
	}

	AtomicInteger total = new AtomicInteger();
	
	
	@RabbitListener(queues = "trips")
	@SendTo("itineraries")
	public Itinerary handleMessage(TripBooking trip) {
		log.info("PROCESSING TRIP. Payment card: " + trip.getPaymentCardNumber());
		return trip.getItinerary();
	}

}

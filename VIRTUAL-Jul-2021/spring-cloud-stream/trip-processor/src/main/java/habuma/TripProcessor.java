package habuma;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class TripProcessor {
	
	private static Logger log = LoggerFactory.getLogger(TripProcessor.class); 

	public static void main(String[] args) {
	    System.setProperty("spring.devtools.restart.enabled", "false");

		SpringApplication.run(TripProcessor.class, args);
	}
	
	@Bean
	public Function<TripBooking, Itinerary> processTrip() {
		return trip -> {
			log.info("PROCESSING TRIP. Payment card: " + trip.getPaymentCardNumber());
			return trip.getItinerary();
		};
	}
}

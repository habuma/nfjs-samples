package trips;

import java.util.Date;
import java.util.function.Supplier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ScsTripSourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScsTripSourceApplication.class, args);
	}
	
	@Bean
	public Supplier<TripBooking> sendTrip() {
		return () -> {
			System.out.println("SENDING TRIP...");
			
			Itinerary itinerary = new Itinerary("New York", new Date(), new Date());
			TripBooking tripBooking = new TripBooking("4111111111111111", itinerary);
			return tripBooking;
		};
	}

}

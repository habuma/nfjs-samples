package trips;

import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ScsTripProcessorApplication {

	public static void main(String[] args) {
		SpringApplication.run(ScsTripProcessorApplication.class, args);
	}
	
	@Bean
	public Function<TripBooking, Itinerary> processTrip() {
		return booking -> {
			System.out.println("PROCESSING PAYMENT:  " + booking.getPaymentCardNumber());
			return booking.getItinerary();
		};
	}

}

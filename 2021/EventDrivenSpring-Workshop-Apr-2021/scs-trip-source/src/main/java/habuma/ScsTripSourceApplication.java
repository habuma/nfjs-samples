package habuma;

import java.util.Date;
import java.util.function.Supplier;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import habuma.Itinerary.Destination;

@SpringBootApplication
public class ScsTripSourceApplication {
  private static final Logger log = LoggerFactory.getLogger(ScsTripSourceApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(ScsTripSourceApplication.class, args);
	}
	
	@Bean
	public Supplier<TripBooking> sendTrip() {
	  return () -> {
	    TripBooking trip = new TripBooking();
	    trip.setTravelerName("Craig Walls");
	    trip.setPaymentCardNumber("4111111111111111");
	    Itinerary itinerary = new Itinerary();
	    itinerary.setDestination(Destination.MARS);
	    itinerary.setStartDate(new Date());
      itinerary.setEndDate(new Date());
      trip.setItinerary(itinerary);
      log.info("SENDING TRIP:  " + trip.getTravelerName());
      return trip;
	  };
	}

}

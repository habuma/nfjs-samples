package habuma;

import java.util.Date;

import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import habuma.Itinerary.Destination;

@SpringBootApplication
@EnableScheduling
public class TripSourceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TripSourceApplication.class, args);
	}

  @Bean
  public Queue trips() {
	   return new Queue("trips", true, false, false);
  }
	
	@Autowired
	TripSender tripSender;
	
	@Scheduled(fixedRate=5000)
	public void sendTrip() {
	  TripBooking trip = new TripBooking();
	  Itinerary itinerary = new Itinerary();
	  itinerary.setDestination(Destination.JUPITER);
	  itinerary.setStartDate(new Date());
    itinerary.setEndDate(new Date());
    trip.setItinerary(itinerary);
	  trip.setTravelerName("Craig Walls");
	  trip.setPaymentCardNumber("4111111111111111");
	  tripSender.sendTrip(trip);
	}

}

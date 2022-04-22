package habuma;

import java.time.Duration;
import java.time.Instant;
import java.util.Date;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.integration.amqp.dsl.Amqp;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import habuma.Itinerary.Destination;

@SpringBootApplication
@EnableScheduling
public class RandomTripSource {
	private static Logger log = LoggerFactory.getLogger(RandomTripSource.class); 

	private static final String[] TRAVELERS = {
			"Mickey", 
			"Donald",
			"Goofy",
			"Minnie",
			"Daisy"
	};
	
	private static final String[] CARD_NUMBERS = {
			"4417123456789113",
			"4111111111111111"
	};

	private Random random = new Random();
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(RandomTripSource.class, args);
	}
	
	@Autowired
	TripSender tripSender;
	
	@Scheduled(fixedRate = 1000)
	public void sendTrip() {
		TripBooking trip = new TripBooking();
		trip.setTravelerName(pickItem(TRAVELERS));
		trip.setPaymentCardNumber(pickItem(CARD_NUMBERS));
		trip.setItinerary(pickItinerary());
		log.info("SENDING TRIP:  " + trip);
		
		TripBooking sent = tripSender.sendTrip(trip);
		System.out.println("SENT:  " + sent);
	}
	
	 @Bean
	 public DirectChannel tripChannel() {
	  return new DirectChannel();
	 }
	
	@Bean
	public IntegrationFlow tripFlow(
			AmqpTemplate amqpTemplate) {
	    return IntegrationFlows.from(tripChannel())
				.handle(Amqp.outboundGateway(amqpTemplate).routingKey("trips"))
	            .get();
	}
	
	// random data generators
	
	private <T> T pickItem(T[] items) {
		return items[random.nextInt(items.length)];
	}
	
	private Itinerary pickItinerary() {
		Destination destination = pickItem(Destination.values());
		Instant startDate = Instant.now().plus(Duration.ofDays(random.nextInt(10)));
		Instant returnDate = startDate.plus(Duration.ofDays(random.nextInt(10)));
		return new Itinerary(destination,
				new Date(startDate.toEpochMilli()), 
				new Date(returnDate.toEpochMilli()));
	}

}

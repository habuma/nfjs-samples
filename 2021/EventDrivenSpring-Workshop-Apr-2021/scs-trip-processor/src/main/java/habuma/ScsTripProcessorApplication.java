package habuma;

import java.util.function.Function;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ScsTripProcessorApplication {
  private static final Logger log = LoggerFactory.getLogger(ScsTripProcessorApplication.class);

  public static void main(String[] args) {
    SpringApplication.run(ScsTripProcessorApplication.class, args);
  }

  @Bean
  public Function<TripBooking, Itinerary> processTrip() {
    return trip -> {
      log.info("PROCESSING TRIP. Payment card: " + trip.getPaymentCardNumber());
      return trip.getItinerary();
    };
  }

}

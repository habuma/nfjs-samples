package habuma;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

@Component
public class TripHandler {

  private static final Logger log = LoggerFactory.getLogger(TripHandler.class);
  
  @RabbitListener(queues = "trips")
  @SendTo("itineraries")
  public Itinerary processTrip(TripBooking trip) {
    log.info("PROCESSING TRIP:  Payment card: " + trip.getPaymentCardNumber());
    return trip.getItinerary();
  }
  
}

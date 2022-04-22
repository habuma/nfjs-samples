package habuma;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class TripSink {

  private static Logger log = LoggerFactory.getLogger(TripSink.class);
  
  @RabbitListener(queues = "itineraries")
  public void logItinerary(Itinerary itinerary) {
    log.info("ITINERARY:  " + itinerary.getDestination());
  }
  
}

package habuma;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TripSender {

  private final RabbitTemplate rabbit;

  @Autowired
  public TripSender(RabbitTemplate rabbit) {
    this.rabbit = rabbit;
  }
  
  public void sendTrip(TripBooking trip) {
    rabbit.convertAndSend("trips", trip);
  }
  
}

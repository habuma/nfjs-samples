package habuma;

import org.springframework.integration.annotation.Gateway;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.scheduling.annotation.Async;

@MessagingGateway
public interface TripSender {

	@Gateway(requestChannel = "tripChannel")
	TripBooking sendTrip(TripBooking trip);
	
}

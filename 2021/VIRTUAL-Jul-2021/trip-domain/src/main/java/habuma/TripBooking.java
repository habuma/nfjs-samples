package habuma;

import java.io.Serializable;

import lombok.Data;

@Data
public class TripBooking implements Serializable {

	private static final long serialVersionUID = 1L;

	private String travelerName;
	
	private String paymentCardNumber;

	private Itinerary itinerary;
	
}

package trips;

import java.io.Serializable;

public class TripBooking implements Serializable {
	private static final long serialVersionUID = 1L;
	private String paymentCardNumber;
	private Itinerary itinerary;
	
	public TripBooking() {}
	
	public TripBooking(String paymentCardNumber, Itinerary itinery) {
		this.paymentCardNumber = paymentCardNumber;
		itinerary = itinery;
	}
	
	public String getPaymentCardNumber() {
		return paymentCardNumber;
	}
	
	public void setPaymentCardNumber(String paymentCardNumber) {
		this.paymentCardNumber = paymentCardNumber;
	}
	
	public Itinerary getItinerary() {
		return itinerary;
	}
	
	public void setItinerary(Itinerary itinerary) {
		this.itinerary = itinerary;
	}
	
}

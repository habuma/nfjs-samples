package habuma;

import java.io.Serializable;

public class TripBooking implements Serializable {

	private static final long serialVersionUID = 1L;

	private String travelerName;
	
	private String paymentCardNumber;

	private Itinerary itinerary;
	
	public TripBooking() {}
	
	public TripBooking(String travelerName, String paymentCardNumber, Itinerary itinerary) {
		this.travelerName = travelerName;
		this.paymentCardNumber = paymentCardNumber;
		this.itinerary = itinerary;
	}
	
	@Override
	public String toString() {
		return "(travelerName=" + travelerName + ", paymentCardNumber=" + paymentCardNumber + ", itinerary = " + itinerary + ")";
	}

	public String getTravelerName() {
		return travelerName;
	}

	public void setTravelerName(String travelerName) {
		this.travelerName = travelerName;
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

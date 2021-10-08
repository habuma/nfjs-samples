package habuma;

import java.io.Serializable;
import java.util.Date;

public class Itinerary implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Destination destination;
	private Date startDate;
	private Date returnDate;

	public static enum Destination {
		MERCURY, VENUS, MARS, JUPITER, SATURN, URANUS, NEPTUNE, PLUTO
	}
	
	public Itinerary() {}
	
	public Itinerary(Destination destination, Date startDate, Date returnDate) {
		this.destination = destination;
		this.startDate = startDate;
		this.returnDate = returnDate;
	}
	
	@Override
	public String toString() {
		return "(destination=" + destination + 
				", startDate=" + startDate + 
				", returnDate=" + returnDate + ")";
	}
	
	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	
}

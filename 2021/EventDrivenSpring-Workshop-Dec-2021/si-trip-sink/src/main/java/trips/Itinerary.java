package trips;

import java.io.Serializable;
import java.util.Date;

public class Itinerary implements Serializable {

	private static final long serialVersionUID = 1L;
	private String destination;
	private Date startDate;
	private Date returnDate;
	
	public Itinerary() {}
	
	public Itinerary(
			String destination, 
			Date startDate, Date returnDate) {
		this.destination = destination;
		this.startDate = startDate;
		this.returnDate = returnDate;
	}
	
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
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

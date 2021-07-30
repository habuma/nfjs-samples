package habuma;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Itinerary implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private Destination destination;
	private Date startDate;
	private Date returnDate;

	public static enum Destination {
		MERCURY, VENUS, MARS, JUPITER, SATURN, URANUS, NEPTUNE, PLUTO
	}
	
}

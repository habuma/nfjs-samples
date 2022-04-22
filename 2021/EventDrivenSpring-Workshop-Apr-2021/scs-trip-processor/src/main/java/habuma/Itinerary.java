package habuma;

import java.io.Serializable;
import java.util.Date;

import org.springframework.core.style.ToStringCreator;

public class Itinerary implements Serializable {
  private static final long serialVersionUID = 1L;
    private Destination destination;
    private Date startDate;
    private Date endDate;
    
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

    public Date getEndDate() {
      return endDate;
    }

    public void setEndDate(Date endDate) {
      this.endDate = endDate;
    }

    public static enum Destination {
      MERCURY, VENUS, MARS, JUPITER, SATURN, URANUS, NEPTUNE, PLUTO
    }
    
    @Override
    public String toString() {
      return new ToStringCreator(this).toString();
    }
  
}

package rsocket;

import java.time.Instant;

public class Alert {

	private Level level;
	private String orderedBy;
	private Instant orderedAt;

	public Alert() {}
	
	public Alert(Level level, String orderedBy, Instant orderedAt) {
		this.level = level;
		this.orderedAt = orderedAt;
		this.orderedBy = orderedBy;
	}
	
	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public String getOrderedBy() {
		return orderedBy;
	}

	public void setOrderedBy(String orderedBy) {
		this.orderedBy = orderedBy;
	}

	public Instant getOrderedAt() {
		return orderedAt;
	}

	public void setOrderedAt(Instant orderedAt) {
		this.orderedAt = orderedAt;
	}
	
	public enum Level {
		YELLOW, ORANGE, RED, BLACK
	}
}

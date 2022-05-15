package habuma;

public class CountEntry {

	private Long count;
	private Long timestamp;
	
	public Long getCount() {
		return count;
	}

	public void setCount(Long count) {
		this.count = count;
	}

	public Long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Long timestamp) {
		this.timestamp = timestamp;
	}

	public CountEntry(Long count, Long timestamp) {
		this.count = count;
		this.timestamp = timestamp;
	}
	
}

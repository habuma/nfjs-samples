package habuma;

public class CounterObject {

	private String count;
	private Long timestamp;

	public CounterObject(String count, Long timestamp) {
		this.count = count;
		this.timestamp = timestamp;
	}
	
	public String getCount() {
		return count;
	}
	
	public Long getTimestamp() {
		return timestamp;
	}
	
}

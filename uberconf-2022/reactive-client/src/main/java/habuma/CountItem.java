package habuma;

public class CountItem {

	private long count;
	private long timestamp;
	
	public CountItem() {}
	
	public CountItem(long count, long timestamp) {
		this.count = count;
		this.timestamp = timestamp;
	}
	
	public long getCount() {
		return count;
	}
	public void setCount(long count) {
		this.count = count;
	}
	public long getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}
	
}

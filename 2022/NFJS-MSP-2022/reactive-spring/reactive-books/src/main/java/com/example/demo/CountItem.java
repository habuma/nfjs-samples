package com.example.demo;

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
	
	public long getTimestamp() {
		return timestamp;
	}
	
}

package com.example.demo;

public class CounterEntry {

	private long count;
	private long time;
	
	public CounterEntry() {}
	
	public CounterEntry(long count, long time) {
		this.count = count;
		this.time = time;
	}
	
	public long getCount() {
		return count;
	}
	
	public long getTime() {
		return time;
	}
	
}

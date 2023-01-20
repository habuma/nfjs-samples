package com.example.demo;

public class StandardizedError {

	private Long code;
	private String reason;
	
	public StandardizedError(Long code, String reason) {
		this.code = code;
		this.reason = reason;
	}
	
	public Long getCode() {
		return code;
	}
	public void setCode(Long code) {
		this.code = code;
	}
	public String getReason() {
		return reason;
	}
	public void setReason(String reason) {
		this.reason = reason;
	}
}

package com.example.demo;

public class StandardError {

	private int code;
	private String message;
	private String suggestedResolution;
	
	public StandardError() {}
	
	public StandardError(int code, String message, String suggestResolution) {
		this.code = code;
		this.message = message;
		suggestedResolution = suggestResolution;
	}
	
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getSuggestedResolution() {
		return suggestedResolution;
	}
	public void setSuggestedResolution(String suggestedResolution) {
		this.suggestedResolution = suggestedResolution;
	}
	
	
	
}

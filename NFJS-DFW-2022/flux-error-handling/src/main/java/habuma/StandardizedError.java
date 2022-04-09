package habuma;

public class StandardizedError {

	private int apiCode;
	private String message;
	
	public StandardizedError() {}
	
	public StandardizedError(int apiCode, String message) {
		this.apiCode = apiCode;
		this.message = message;
	}
	
	public void setApiCode(int apiCode) {
		this.apiCode = apiCode;
	}
	
	public int getApiCode() {
		return apiCode;
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	
}

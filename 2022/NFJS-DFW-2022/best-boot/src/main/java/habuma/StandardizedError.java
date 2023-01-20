package habuma;

public class StandardizedError {

	private int apiErrorCode;
	private String message;
	
	public StandardizedError(int apiErrorCode, String message) {
		this.apiErrorCode = apiErrorCode;
		this.message = message;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public int getApiErrorCode() {
		return apiErrorCode;
	}
	public void setApiErrorCode(int apiErrorCode) {
		this.apiErrorCode = apiErrorCode;
	}
	
}

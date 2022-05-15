package habuma;

public class StandardError {

	private Long apiErrorCode;
	private String message;
	
	public StandardError(Long apiErrorCode, String message) {
		this.apiErrorCode = apiErrorCode;
		this.message = message;
	}
	
	public Long getApiErrorCode() {
		return apiErrorCode;
	}
	
	public String getMessage() {
		return message;
	}
	
}

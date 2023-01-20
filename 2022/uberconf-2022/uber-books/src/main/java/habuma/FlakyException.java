package habuma;

public class FlakyException extends RuntimeException {
 
	private static final long serialVersionUID = 1L;

	public FlakyException(String message) {
		super(message);
	}
	
}

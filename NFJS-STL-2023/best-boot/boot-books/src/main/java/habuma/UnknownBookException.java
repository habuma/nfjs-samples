package habuma;

public class UnknownBookException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UnknownBookException(String isbn) {
		super("Book with ISBN + " + isbn + " not found.");
	}
	
}

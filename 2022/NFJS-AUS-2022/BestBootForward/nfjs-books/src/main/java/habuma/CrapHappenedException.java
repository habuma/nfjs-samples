package habuma;

public class CrapHappenedException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CrapHappenedException(String reason) {
		super(reason);
	}
	
}

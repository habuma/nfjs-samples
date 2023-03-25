package habuma;

public class BookNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 1L;

  public BookNotFoundException(String isbn) {
    super("Book with ISBN " + isbn + " not found.");
  }
  
}

package habuma;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@NoArgsConstructor(force=true)
@RequiredArgsConstructor
public class Book {

	private Long id;
	private final String isbn;
	private final String title;
	private final String author;
	
}

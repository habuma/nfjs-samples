package habuma.books;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@NoArgsConstructor(force=true, access = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class Book {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private final String isbn;
	private final String title;
	private final String author;
	
}

package habuma;

import java.util.Optional;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;

@SpringBootApplication
public class BooksQlApplication {

	public static void main(String[] args) {
		SpringApplication.run(BooksQlApplication.class, args);
	}

	@Bean
	ApplicationRunner dataLoader(BookRepository bookRepo, AuthorRepository authorRepo) {
	  return args -> {
	    Author kendall = authorRepo.save(new Author("Kendall", "Crolius"));
	    Author kaori = authorRepo.save(new Author("Kaori", "Tsutasy"));
	    
	    bookRepo.save(new Book("1122334455", "Knitting with Dog Hair", kendall));
      bookRepo.save(new Book("5544332211", "Crafting with Cat Hair", kaori));
      
//      Optional<Book> findOne = bookRepo.findOne(Example.of(new Book("1122334455", null, null)));
//      if (findOne.isPresent()) {
//        Book book = findOne.get();
//        System.out.println(book.getTitle() + " by " + 
//            book.getAuthor().getLastName() + " ; ISBN: " + book.getIsbn());
//      }
	  };
	}
	
}

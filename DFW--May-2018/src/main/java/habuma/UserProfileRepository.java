package habuma;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserProfileRepository 
		extends CrudRepository<UserProfile, Long>, 
				UserProfileExtras {
	
	Iterable<UserProfile> findByFirstName(String fn);
	
	UserProfile findByUsername(String un);
	
	@Query("{'firstName':'Ken'}")
	Iterable<UserProfile> findAllTheKens();
	
	// Won't work!!!
	// Iterable<Book> findByPublisher_Address_ZipCode(String zc);
	
}

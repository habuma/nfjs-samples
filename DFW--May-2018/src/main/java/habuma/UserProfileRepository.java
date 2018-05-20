package habuma;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface UserProfileRepository 
		extends CrudRepository<UserProfile, Long>, 
				UserProfileExtras,
				QueryByExampleExecutor<UserProfile> {
	
	Iterable<UserProfile> findByFirstName(String fn);
	
	UserProfile findByUsername(@Param("username") String un);

	SimpleUserProfile findSimpleByUsername(String un);
	
	@Query("from UserProfile p where p.firstName = 'Ken'")
	Iterable<UserProfile> findAllTheKens();
	
	// Won't work!!!
	// Iterable<Book> findByPublisher_Address_ZipCode(String zc);
	
}

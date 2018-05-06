package habuma;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserProfileRepository 
		extends CrudRepository<UserProfile, String>,
				UserProfileRepositoryExtras {
	
	UserProfile findByUsername(String un);
	int countByUsername(String un);	
	Iterable<UserProfile> findByLastName(String ln);
	
	@Query("{'username':'habuma'}")
	UserProfile findCraig();
	
}

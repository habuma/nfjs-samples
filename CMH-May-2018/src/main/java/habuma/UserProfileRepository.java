package habuma;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

public interface UserProfileRepository 
		extends CrudRepository<UserProfile, Long>,
				UserProfileRepositoryExtras {
	
	UserProfile findByUsername(String un);
	int countByUsername(String un);	
	Iterable<UserProfile> findByLastName(String ln);
	
	@Query("from UserProfile p "
		  +"where p.username='habuma'")
	UserProfile findCraig();
	
}

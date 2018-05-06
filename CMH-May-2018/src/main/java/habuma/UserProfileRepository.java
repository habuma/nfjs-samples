package habuma;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface UserProfileRepository 
		extends CrudRepository<UserProfile, Long>,
				UserProfileRepositoryExtras,
				QueryByExampleExecutor<UserProfile> {
	
	UserProfile findByUsername(String un);

	SimpleUserProfile findSimpleUserProfileByUsername(String un);

	
	int countByUsername(String un);	
	
	
	
	Iterable<UserProfile> findByLastName(@Param("lastname") String ln);
	
	
	
	
	@Query("from UserProfile p "
		  +"where p.username='habuma'")
	UserProfile findCraig();
	
}

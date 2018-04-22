package habuma;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface UserProfileRepository 
         extends CrudRepository<UserProfile, Long>,
                 UserProfileRepositoryExtras,
                 QueryByExampleExecutor<UserProfile> {
	
	UserProfile findByUsername(@Param("un") String username);

	SimpleProfile findSimpleProfileByUsername(@Param("un") String username);

	Iterable<UserProfile> findByLastName(@Param("ln") String ln);
	
	int countByFirstName(@Param("fn") String fn);
	
	
}

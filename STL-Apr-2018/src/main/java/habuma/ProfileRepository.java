package habuma;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.QueryByExampleExecutor;

public interface ProfileRepository 
         extends CrudRepository<Profile, Long>,
         		 ProfileRepositoryExtras,
         		 QueryByExampleExecutor<Profile> {
	
	Iterable<Profile> findByPassword(String password);
	
	Iterable<Profile> findByPasswordAndEnabled(String pwd, boolean e);
	
	Profile findByUsername(String u);
	
	int countByPassword(String p);
	
	@Query("from Profile p where p.username='venkat'")
	Profile findVenkatsProfile();
	
}

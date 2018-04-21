package habuma;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ProfileRepository 
         extends CrudRepository<Profile, String>,
                 ProfileRepositoryExtras {
	
	Profile findByUsername(@Param("un") String username);
	
	Iterable<Profile> findByLastName(String ln);
	
	int countByFirstName(String fn);
	
	
	@Query("{'firstName':'Ken'}")
	Iterable<Profile> findAllTheKenPeople();
	
	
}

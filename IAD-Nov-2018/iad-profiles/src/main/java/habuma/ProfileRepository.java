package habuma;

import org.springframework.data.repository.CrudRepository;

public interface ProfileRepository 
	extends CrudRepository<Profile, Long> {

	Profile findByUsername(String username);
	
}

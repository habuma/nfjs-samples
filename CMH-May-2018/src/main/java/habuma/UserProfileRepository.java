package habuma;

public interface UserProfileRepository {

	Iterable<UserProfile> findAll();
	
	UserProfile findByUsername(String username);
	
	UserProfile save(UserProfile up);
	
	
}

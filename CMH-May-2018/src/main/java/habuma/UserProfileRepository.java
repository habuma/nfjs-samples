package habuma;

public interface UserProfileRepository {

	Iterable<UserProfile> findAll();
	UserProfile save(UserProfile up);
	
}

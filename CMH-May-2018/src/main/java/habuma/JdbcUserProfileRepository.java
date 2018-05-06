package habuma;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class JdbcUserProfileRepository 
		implements UserProfileRepository {

	private final JdbcTemplate jdbc;

	@Override
	public Iterable<UserProfile> findAll() {
		return jdbc.query("select username, password, firstName, lastName "
				+ "from UserProfiles", 
				(rs, rowNum) -> {
					return new UserProfile(rs.getString("username"), 
							rs.getString("password"), 
							rs.getString("firstName"),
							rs.getString("lastName"));
				});
	}

	@Override
	public UserProfile save(UserProfile up) {
		jdbc.update("insert into UserProfiles "
				+ "(username, password, firstName, lastName) "
				+ "values (?, ?, ?, ?)",
				up.getUsername(), up.getPassword(),
				up.getFirstName(), up.getLastName());
		
		
		return up;
	}

}

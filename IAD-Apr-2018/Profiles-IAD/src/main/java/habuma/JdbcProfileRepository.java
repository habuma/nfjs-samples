package habuma;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class JdbcProfileRepository
		implements ProfileRepository {

	private final JdbcTemplate jdbc;
	
	@Override
	public Iterable<Profile> findAll() {
		return jdbc.query("select username, firstName, lastName from profiles",
				(rs, rowNum) -> {
					return new Profile(rs.getString("username"), 
							rs.getString("firstName"),
							rs.getString("lastName"));
				});
	}
	
}

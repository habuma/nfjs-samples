package habuma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class DataLoader implements CommandLineRunner {

	private final UserProfileRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		repo.save(new UserProfile("habuma", "password", "Craig", "Walls"));
		repo.save(new UserProfile("hinojosa", "password", "Daniel", "Hinojosa"));
		repo.save(new UserProfile("venkats", "password", "Venkat", "Subramaniam"));
		repo.save(new UserProfile("ken", "password", "Ken", "Kousen"));
		repo.save(new UserProfile("sipe", "password", "Ken", "Sipe"));
	}
	
}

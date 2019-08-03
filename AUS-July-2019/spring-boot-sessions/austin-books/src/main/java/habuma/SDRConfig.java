package habuma;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

@Configuration
public class SDRConfig implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config
			.withEntityLookup()
				.forRepository(BooksRepository.class,
						Book::getIsbn,
						BooksRepository::findByIsbn);
	}
	
}

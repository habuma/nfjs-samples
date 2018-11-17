package habuma;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class RestConfiguration {

	@Bean
	public RepositoryRestConfigurerAdapter sdrCustomizer() {
		return new RepositoryRestConfigurerAdapter() {
			@Override
			public void configureRepositoryRestConfiguration(
					        RepositoryRestConfiguration config) {
				config
					.withEntityLookup()
					.forRepository(BookRepository.class,
							Book::getIsbn, BookRepository::findByIsbn);
			}
		};
	}
	
}

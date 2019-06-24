package habuma;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class DataConfig {

	@Bean
	public RepositoryRestConfigurer sdrConfig() {
		return new RepositoryRestConfigurer() {
			@Override
			public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
				config
					.withEntityLookup()
					.forRepository(
							BooksRepository.class,
							Book::getIsbn,
							BooksRepository::findByIsbn
							);
					
			}
		};
	}
	
}

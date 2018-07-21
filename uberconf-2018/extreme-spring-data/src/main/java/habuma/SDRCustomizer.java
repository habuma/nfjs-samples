package habuma;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;
import org.springframework.stereotype.Component;

@Component
public class SDRCustomizer extends RepositoryRestConfigurerAdapter {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		
		config
			.withEntityLookup()
			.forRepository(BookRepository.class,
					Book::getIsbn, 
					BookRepository::findByIsbn);
		
	}
}

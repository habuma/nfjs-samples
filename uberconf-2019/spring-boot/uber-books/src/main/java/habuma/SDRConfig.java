package habuma;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Component;

@Component
public class SDRConfig implements RepositoryRestConfigurer {

	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config
			.withEntityLookup()
			.forRepository( BookRepository.class, 
							Book::getIsbn, 
							BookRepository::findByIsbn);
	}
	
}

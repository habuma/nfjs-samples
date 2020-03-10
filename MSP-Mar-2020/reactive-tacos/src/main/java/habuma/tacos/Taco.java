package habuma.tacos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@Document
public class Taco {

	@Id
	private String id;
	
	private final String name;
	private final String wrap;
	private final String filling;
	
}

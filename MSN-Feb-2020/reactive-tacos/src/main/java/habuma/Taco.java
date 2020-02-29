package habuma;

import org.springframework.data.annotation.Id;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
public class Taco {

	@Id
	private Long id;
	
	private final String name;
	private final String wrap;
	private final String filling;
	
}

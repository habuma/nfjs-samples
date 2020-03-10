package habuma.tacos;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor(force=true, access=AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class Taco {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private final String name;
	private final String wrap;
	private final String filling;
	
}

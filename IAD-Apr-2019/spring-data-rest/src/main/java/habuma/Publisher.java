package habuma;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
public class Publisher {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	
	private final String name;

	@ManyToOne(cascade=CascadeType.MERGE)
	private final Address address;
	
}

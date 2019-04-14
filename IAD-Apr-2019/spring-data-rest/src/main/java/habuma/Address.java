package habuma;

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
@RequiredArgsConstructor
@NoArgsConstructor(access=AccessLevel.PRIVATE, force=true)
public class Address {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private final String street;
	private final String city;
	private final String state;
	private final String zipCode;
	
}

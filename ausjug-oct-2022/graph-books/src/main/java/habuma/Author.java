package habuma;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Author {

	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	
	public Author() {}
	
	public Author(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
	}
	
	public Long getId() {
		return id;
	}
	
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
}

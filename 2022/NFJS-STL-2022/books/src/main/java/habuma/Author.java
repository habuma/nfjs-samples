package habuma;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Author {

	@Id
	@GeneratedValue
	private Long id;
	private String firstName;
	private String lastName;
	private String twitterHandle;
	
	public Author() {}
	
	public Author(String firstName, String lastName, String twitterHandle) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.twitterHandle = twitterHandle;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getTwitterHandle() {
		return twitterHandle;
	}
	public void setTwitterHandle(String twitterHandle) {
		this.twitterHandle = twitterHandle;
	}
	
}

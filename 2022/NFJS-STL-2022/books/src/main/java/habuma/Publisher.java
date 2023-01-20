package habuma;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Publisher {

	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private String city;
	
	public Publisher() {}
	
	public Publisher(String name, String city) {
		this.name = name;
		this.city = city;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}

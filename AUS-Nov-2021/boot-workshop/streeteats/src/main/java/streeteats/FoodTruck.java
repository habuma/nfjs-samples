package streeteats;

import org.springframework.data.annotation.Id;

public class FoodTruck {

	@Id
	private Long id;
	
	private String name;
	
	private Category category;
	
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public enum Category {
		MEXICAN,
		VEGAN,
		BURGERS,
		SANDWICHES,
		BARBECUE
	};
	
}

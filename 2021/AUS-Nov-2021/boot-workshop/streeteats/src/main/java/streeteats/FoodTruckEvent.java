package streeteats;

import org.springframework.data.annotation.Id;

public class FoodTruckEvent {

	@Id
	private Long id;
	
	private String name;
	
	private Long foodTruckId;

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

	public Long getFoodTruckId() {
		return foodTruckId;
	}

	public void setFoodTruckId(Long foodTruckId) {
		this.foodTruckId = foodTruckId;
	}
	
}

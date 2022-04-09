package habuma;

public class FruitResponse {

	private String fruit;
	
	public FruitResponse() {}
	
	public FruitResponse(String fruit) {
		if (fruit.equals("Carrot")) {
			throw new NotAFruitException(fruit + " is not a fruit!");
		}
		this.fruit = fruit;
	}
	
	public void setFruit(String fruit) {
		this.fruit = fruit;
	}
	
	public String getFruit() {
		return fruit;
	}
		
}

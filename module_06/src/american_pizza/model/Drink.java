package american_pizza.model;

public class Drink implements FoodItem {

	private String name;
	private Double price;
	private Integer calories;

	public Drink(String name, Double price, Integer calories) {
		this.name = name;
		this.price = price;
		this.calories = calories;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Override
	public Integer getCalories() {
		return calories;
	}

	public void setCalories(Integer calories) {
		this.calories = calories;
	}

	@Override
	public String getMenuItemLine() {
		return this.name + " - calories: " + this.calories + " - price: " + this.price;
	}

}

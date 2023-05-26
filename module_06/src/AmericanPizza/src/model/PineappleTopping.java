package model;

public class PineappleTopping extends PizzaTopping {

	private final String name = "Pineapple";
	private final Double price = 0.79;
	private final Integer calories = 24;

	public PineappleTopping(Pizza pizza) {
		super(pizza);
	}

	@Override
	public String getName() {
		return this.pizza.getName() + " + " + this.name;
	}

	@Override
	public Double getPrice() {
		return this.pizza.getPrice() + this.price;
	}

	@Override
	public Integer getCalories() {
		return this.pizza.getCalories() + this.calories;
	}

	@Override
	public String getMenuItemLine() {
		return this.name + " - calories: " + this.calories + " - price: " + this.price;
	}

}

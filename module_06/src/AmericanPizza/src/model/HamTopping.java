package model;

public class HamTopping extends PizzaTopping {

	private final String name = "Ham";
	private final Double price = 0.99;
	private final Integer calories = 35;

	public HamTopping(Pizza pizza) {
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

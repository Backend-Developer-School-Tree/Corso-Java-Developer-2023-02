package model;

public class SalamiTopping extends PizzaTopping {

	private final String name = "Salami";
	private final Double price = 0.99;
	private final Integer calories = 86;

	public SalamiTopping(Pizza pizza) {
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

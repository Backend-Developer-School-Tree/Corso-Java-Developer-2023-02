package american_pizza.model;

public class CheeseTopping extends PizzaTopping {

	private final String name = "Cheese";
	private final Double price = 0.69;
	private final Integer calories = 92;

	public CheeseTopping(Pizza pizza) {
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

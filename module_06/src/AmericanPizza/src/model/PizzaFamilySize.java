package model;

/**
 *
 * Classe che modella la pizza formato famiglia applicando il sovrapprezzo e
 * raddoppiando le calorie della pizza iniziale
 *
 **/
public class PizzaFamilySize implements Pizza {

	private Pizza pizza;
	private final Integer perCalories = 2;
	private final Double plusPrice = 4.15;

	public PizzaFamilySize(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public String getName() {
		return this.getPizza().getName() + " + " + "Family size";
	}

	@Override
	public Double getPrice() {
		return this.getPizza().getPrice() + this.plusPrice;
	}

	@Override
	public Integer getCalories() {
		return this.getPizza().getCalories() * this.perCalories;
	}

	@Override
	public String getMenuItemLine() {
		return "Family size for Pizza" + " - Calories: x" + this.perCalories + " - Price: +" + this.plusPrice;
	}

	public Pizza getPizza() {
		return pizza;
	}

	public void setPizza(Pizza pizza) {
		this.pizza = pizza;
	}

}

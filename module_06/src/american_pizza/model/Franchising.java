package american_pizza.model;


public class Franchising implements MenuItem {

	private String name;
	private Double price;

	public Franchising(String name, Double price) {
		this.name = name;
		this.price = price;
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
	public String getMenuItemLine() {
		return this.name + " - price: " + this.price;
	}

}

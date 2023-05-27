package model;

/**
 *
 * Classe astratta che definisce il modello di un topping secondo il pattern
 * Decorator aggiungendo al costruttore l'istanza della classe Pizza a cui il
 * topping deve essere applicato
 *
 **/

public abstract class PizzaTopping implements Pizza {

	protected final Pizza pizza;

	public PizzaTopping(Pizza pizza) {
		this.pizza = pizza;

	}

}

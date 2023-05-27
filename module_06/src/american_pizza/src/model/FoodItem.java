package model;

/**
 * Interfaccia di base per i prodotti alimentari (pizze e bevande) che estende
 * l'interfaccia MenuItem aggiungendo l'attributo relativo alle calorie
 *
 **/
public interface FoodItem extends MenuItem {

	public Integer getCalories();

}

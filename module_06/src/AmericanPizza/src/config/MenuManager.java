package config;

import model.Pizza;
import persistance.DummyDB;

public class MenuManager {

	DummyDB dummyDB;

	public MenuManager(){
		dummyDB = new DummyDB();
		dummyDB.initDB();
	}

	public void printMenu(){
		System.out.println("**** PRINT MENU ****");

		for(Pizza pizza : dummyDB.getMenuPizza()){
			System.out.println(pizza.getMenuItemLine());
		}

	}

}

package fr.pizzeria.ihm;

import java.util.Collection;
import java.util.function.Consumer;

import fr.pizzeria.model.Pizza;

public class ListerPizzaAction extends Action {

	public ListerPizzaAction(IhmHelper helper) {
		super("Lister les pizzas", helper);
	}

	
	public void execute() {
		System.out.println("**** Liste de Pizzas ****");
		Collection<Pizza> pizzas = this.helper.getStockagePizza().findAll();
	/*	
    	// en java 7
			for (Pizza pizzaEnCours : pizzas) {
				System.out.println(pizzaEnCours.getCode() + " " + pizzaEnCours.getNom() + " " + pizzaEnCours.getPrix());
			}
			System.out.println("\n");
	*/
		
		// En java 8
		
		pizzas.forEach(pizzaEnCours -> {
			
			System.out.println(pizzaEnCours.toString());
		}); 
		System.out.println("\n");
		
		// ou bien 
		
		/*
		pizzas.forEach(new Consumer<Pizza>() {

			@Override
			public void accept(Pizza pizzaEnCours) {
				System.out.println(pizzaEnCours.getCode() + " " + pizzaEnCours.getNom() + " " + pizzaEnCours.getPrix());
			}
		});
		System.out.println("\n");
		
		*/
		//
	}

}

package fr.pizzeria.admin.web;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockagePizzaJPA;

public class ServiceConfig {
	
	@Produces
	@ApplicationScoped
	public Stockage<Pizza, String> getStockagePizza(){
		return new StockagePizzaJPA();
		
	}

}

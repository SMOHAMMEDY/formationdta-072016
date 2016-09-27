package dta;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.pizzeria.model.Pizza;

@Repository
public class StockagePizzaParLotSpringJdbc {

	@Autowired StockagePizzaSpringJdbc stockagePizzaSpringJdbc;
	
	public void insertParLot(List<Pizza> pizzas){
		
		// découper la pizza par lot de 3
		
		//List
		// inserer les pizzas par lot de 3
		
			
		
	}
}

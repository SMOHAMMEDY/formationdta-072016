package dta.transaction;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dta.StockagePizzaSpringJdbc;
import dta.beans.SpringConfig;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class) // délégé l'injection du beans sans passer par la création du contexte
@ContextConfiguration(classes=SpringConfig.class) // configuration de spring
public class SpringJdbcTransactionTest {
	
	@Autowired private StockagePizzaSpringJdbc stockageParLot;

	@Test
	public void testParLot(){
		List<Pizza> pizzas = new ArrayList<>();
		
		// a completer 
		
		stockageParLot.insererParLot(pizzas);
	}
}

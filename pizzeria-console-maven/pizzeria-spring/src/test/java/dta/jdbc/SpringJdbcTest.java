package dta.jdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dta.StockagePizzaSpringJdbc;
import dta.beans.SpringConfig;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

@RunWith(SpringJUnit4ClassRunner.class) // délégé l'injection du beans sans passer par la création du contexte
@ContextConfiguration(classes=SpringConfig.class) // configuration de spring
public class SpringJdbcTest {
	
	@Autowired private StockagePizzaSpringJdbc stockage;
	
	@Test
	public void ListerLesPizzas(){
		
		stockage.findAll().forEach(System.out::println);
	}

	@Test
	public void AjoutPizza(){
		
		Pizza nouvellePizza = new Pizza("PEP", "PEPERONI", 10, CategoriePizza.VIANDE,"peperoni.jpg");
		Pizza nouvellePizza2 = new Pizza("SAU", "SAUMON", 15, CategoriePizza.POISSON,"saumon.jpg");
		stockage.save(nouvellePizza);
		stockage.save(nouvellePizza2);
		System.out.println("les pizzas crées sont: /n" ); 
		
		stockage.findAll().forEach(System.out::println); 
	}
	
}

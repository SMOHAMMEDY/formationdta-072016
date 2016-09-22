package dta;

import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockagePizzaJPA;


public class SpringBeansAnnotationTest {

	@Test
	public void testCréationBeans(){
		try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class)) {
			
			Stockage<Pizza,String> pizzaStockage = context.getBean(Stockage.class);
			pizzaStockage.findAll().forEach(System.out::println);
			
		}
		
	}
}

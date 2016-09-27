package dta.beans;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import dta.SpringConsole;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

@RunWith(SpringJUnit4ClassRunner.class) // délégé l'injection du beans sans passer par la création du contexte
@ContextConfiguration(classes=SpringConfig.class) // configuration de spring
public class SpringBeansAnnotationTest {
	
	@Autowired
	private Stockage<Pizza, String> pizzaStockage;
	
	@Autowired
	private SpringConsole sc;
	
	@Test
	public void testCréationBeans(){
		/*try (AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(
                SpringConfig.class)) {
			
			Stockage<Pizza,String> pizzaStockage = context.getBean(Stockage.class); 
	}
			*/ 
	
			pizzaStockage.findAll().forEach(System.out::println);
	}
	
	
	// meme teste autrement
	
	@Test
	public void testSpringConsole(){
		sc.afficherToutesLesPizzas();
	}
}

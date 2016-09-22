package dta;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;


public class SpringBeansXmlTest {

	@Test
	public void testCréationBean(){
		
		try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-config.xml")){
			
			Stockage<Pizza,String> pizzaStockage = context.getBean(Stockage.class);
			
			pizzaStockage.findAll().forEach(System.out::println);
		}
	}
	
	public void testPizza(){
		try(ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("Spring-config.xml")){
			
			Pizza maPizza = context.getBean(Pizza.class);
			
			Assert.assertEquals("pep",maPizza.getCode());
		}
	}
}

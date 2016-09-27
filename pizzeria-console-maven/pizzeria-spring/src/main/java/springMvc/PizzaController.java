package springMvc;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import dta.StockagePizzaSpringJdbc;
import fr.pizzeria.model.Pizza;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {
	
	@Autowired 
	private StockagePizzaSpringJdbc pizzaStockage;

	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseBody
	public List<Pizza> findAll(HttpServletResponse reponse){
		// création liste vide
		List<Pizza> listePizza = new ArrayList<>();
		// le addAll rempli ma liste pizza avec la collection de pizzaStockage.findAll
		listePizza.addAll(pizzaStockage.findAll());

		return listePizza;
		
	}

}

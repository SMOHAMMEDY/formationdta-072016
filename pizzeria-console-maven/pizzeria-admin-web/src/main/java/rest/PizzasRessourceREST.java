package rest;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.inject.Produces;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import fr.pizzeria.ejb.PizzaServiceEJB;
import fr.pizzeria.model.Pizza;



@Path("/pizzas")
public class PizzasRessourceREST {

	@EJB private PizzaServiceEJB stockagePizza;

	@GET
	@javax.ws.rs.Produces(MediaType.APPLICATION_JSON)
	public List<Pizza> listP(){	
	List<Pizza> pizzas = (List<Pizza>) stockagePizza.findAll();
		return pizzas;
		
	}
	
}

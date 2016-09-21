package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.persistence.metamodel.SetAttribute;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.ejb.PizzaServiceEJB;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockagePizzaJPA;
import fr.pizzeria.service.StockageType;


@WebServlet("/pizzas/list") // remplace la supprission du web.xml
public class ListerPizzaController extends HttpServlet{

	//@Inject /*@StockageType*/ private Stockage<Pizza, String> stockagePizza; // plus besoin on va utilisé stockageEJB
	@EJB private PizzaServiceEJB stockagePizza;
	
	/*
	 * GEt retourne la liste des pizzas et appel listPizzas.jsp
	 * */
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//Stockage<Pizza, String> stockagePizza = PersistanceUtils.getInstance().getStockagePizza();
		Collection<Pizza> listP = stockagePizza.findAll();
			
			req.setAttribute("listePizzas", listP);
			
			//RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/listPizzas.jsp");
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/listPizzasJSTL.jsp");
			dispatcher.forward(req, resp);
			
		}
	}
	



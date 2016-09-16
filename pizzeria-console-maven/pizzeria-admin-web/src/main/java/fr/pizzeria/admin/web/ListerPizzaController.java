package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.ResourceBundle;

import javax.persistence.metamodel.SetAttribute;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

public class ListerPizzaController extends HttpServlet{

	/*
	 * GEt retourne la liste des pizzas et appel listPizzas.jsp
	 * */
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

			Collection<Pizza> listP = PersistanceUtils.getInstance().getStockagePizza().findAll();
			
			req.setAttribute("listePizzas", listP);
			
			//RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/listPizzas.jsp");
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/listPizzasJSTL.jsp");
			dispatcher.forward(req, resp);
			
		}
	}
	



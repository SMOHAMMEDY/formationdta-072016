package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.Collection;
import java.util.ResourceBundle;

import javax.ejb.EJB;
import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.ejb.PizzaServiceEJB;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockageType;

@WebServlet("pizzas/ajout") // remplace la supprission du web.xml
public class CreePizzaController extends HttpServlet {
	
	//@Inject /*@StockageType*/ private Stockage<Pizza, String> stockagePizza; // plus besoin on va utilisé stockageEJB
	@EJB private PizzaServiceEJB stockagePizza;
	

	
	// le get pour appeler le formulaire
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/creePizzas.jsp");
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/creePizzasJSTL.jsp");
		dispatcher.forward(req, resp);
		
	}

	// le post pour ajouter la pizza
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		//Stockage<Pizza, String> stockagePizza = PersistanceUtils.getInstance().getStockagePizza(); // est remplacer par @Inject @StockageType private Stockage<Pizza, String> stockagePizza; en haut
			
			String code = req.getParameter("codeP");
			String nom = req.getParameter("nomP");
			double prix = Double.valueOf(req.getParameter("prixP"));
			CategoriePizza cat = CategoriePizza.valueOf(req.getParameter("catP"));
			String url = req.getParameter("urlP");
			
			Pizza pizza = new Pizza(code, nom, prix, cat, url);
			stockagePizza.save(pizza);
			
			resp.sendRedirect(req.getContextPath() + "/pizzas/list");
	
	}

	
}

package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.Collection;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockageType;

@WebServlet("pizzas/edit") // remplace la supprission du web.xml
public class EditerPizzaController extends HttpServlet {
	@Inject /*@StockageType*/ private Stockage<Pizza, String> stockagePizza;
	

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//	Stockage<Pizza, String> stockagePizza = PersistanceUtils.getInstance().getStockagePizza(); // est remplacer par @Inject @StockageType private Stockage<Pizza, String> stockagePizza; en haut
			
			Pizza pizza = stockagePizza.find(req.getParameter("code"));
			
			req.setAttribute("pizza", pizza);
			
			//RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/editPizzas.jsp");
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/pizzas/editPizzasJSTL.jsp");
			dispatcher.forward(req, resp);
			
	
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// Stockage<Pizza, String> stockagePizza = PersistanceUtils.getInstance().getStockagePizza(); // est remplacer par @Inject @StockageType private Stockage<Pizza, String> stockagePizza; en haut
		
			
			String code = req.getParameter("codeP");
			String nom = req.getParameter("nomP");
			double prix = Double.valueOf(req.getParameter("prixP"));
			CategoriePizza cat = CategoriePizza.valueOf(req.getParameter("catP"));
			String url = req.getParameter("urlP");
			
			Pizza pizza = new Pizza(code, nom, prix, cat, url);
			stockagePizza.update(pizza, req.getParameter("code"));
			
			resp.sendRedirect(req.getContextPath() + "/pizzas/list");
	
	}
	
}

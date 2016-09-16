package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockagePizzaJPA;

public class SupprimerPizzaController extends HttpServlet {


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String classeStockagePizza = bundle.getString("pizza.service.Impl");
		System.out.println(classeStockagePizza);
		// creer une classe indiquer dans le fichier application.properties dans srs main ressources
		Class<?> classePizza;
		
		try {
			classePizza = Class.forName(classeStockagePizza);
			Stockage<Pizza, String> stockagePizza = (Stockage<Pizza, String>) classePizza.newInstance();
			
			String code = req.getParameter("codeP");
			String nom = req.getParameter("nomP");
			double prix = Double.valueOf(req.getParameter("prixP"));
			CategoriePizza cat = CategoriePizza.valueOf(req.getParameter("catP"));
			String url = req.getParameter("urlP");
			
			Pizza pizza = new Pizza(code, nom, prix, cat, url);
			stockagePizza.delete(code);
			
			resp.sendRedirect(req.getContextPath() + "/pizzas/list");
	
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

}

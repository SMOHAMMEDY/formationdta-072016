package fr.pizzeria.admin.web;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Collection;
import java.util.ResourceBundle;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.servlet.ServletException;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockagePizzaJPA;

@WebServlet("/api/servlet/pizzas") // remplace la supprission du web.xml
public class PizzaServletWebApi extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String classeStockagePizza = bundle.getString("pizza.service.Impl");
		System.out.println(classeStockagePizza);
		// crer une classe indiquer dans le fichier application.properties dans srs main ressources
		Class<?> classePizza;
		
		try {
			classePizza = Class.forName(classeStockagePizza);
			Stockage<Pizza, String> stockagePizza = (Stockage<Pizza, String>) classePizza.newInstance();
			
			Collection<Pizza> listP = stockagePizza.findAll();
			resp.getWriter().write(listP.toString());
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	

	
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
			
			String code = req.getParameter("code");
			String nom = req.getParameter("nom");
			double prix = Double.valueOf(req.getParameter("prix"));
			CategoriePizza cat = CategoriePizza.valueOf(req.getParameter("cat"));
			String url = req.getParameter("url");
			
			Pizza pizza = new Pizza(code, nom, prix, cat, url);
			stockagePizza.save(pizza);
	
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String classeStockagePizza = bundle.getString("pizza.service.Impl");
		System.out.println(classeStockagePizza);
		// creer une classe indiquer dans le fichier application.properties dans srs main ressources
		Class<?> classePizza;
		
		try {
			// Création de la nouvelle instance de pizza
			classePizza = Class.forName(classeStockagePizza);
			Stockage<Pizza, String> stockagePizza = (Stockage<Pizza, String>) classePizza.newInstance();
			// récupération du string contenant les parametre du ubdate ( ancient code et nouveau parametre de la pizza modifier)
			BufferedReader br = new BufferedReader(new InputStreamReader(req.getInputStream()));
			
			
			//resp.getWriter().write(br.readLine()); il affiche la chaine de caractère avec les &
			
			
		/*	
		 * Pizza pizza = new Pizza(code, nom, prix, cat, url);
			stockagePizza.save(pizza);
		 */
			
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
	}
		
}

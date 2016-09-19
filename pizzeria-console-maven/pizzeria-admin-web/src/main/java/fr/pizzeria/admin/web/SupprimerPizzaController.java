package fr.pizzeria.admin.web;

import java.io.IOException;
import java.util.Collection;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockagePizzaJPA;
import fr.pizzeria.service.StockageType;

@WebServlet("/pizzas/supprim") // remplace la suppression du web.xml
public class SupprimerPizzaController extends HttpServlet {
	@Inject /*@StockageType*/ private Stockage<Pizza, String> stockagePizza;


	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		// Stockage<Pizza, String> stockagePizza = PersistanceUtils.getInstance().getStockagePizza(); // est remplacer par @Inject @StockageType private Stockage<Pizza, String> stockagePizza; en haut
				
			String code = req.getParameter("code");

			stockagePizza.delete(code);
			
			resp.sendRedirect(req.getContextPath() + "/pizzas/list");
	}
}

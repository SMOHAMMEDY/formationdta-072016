package fr.pizzeria.admin.web;

import javax.ejb.EJB;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import fr.pizzeria.ejb.ClientServiceEJB;
import fr.pizzeria.ejb.LivreurServiceEJB;
import fr.pizzeria.ejb.PizzaServiceEJB;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;

@WebListener
public class DemarrageListener implements ServletContextListener{
	@EJB private PizzaServiceEJB stockagePizza;
	@EJB private ClientServiceEJB stockageClient;
	@EJB private LivreurServiceEJB stockageLivreur;
		
	@Override
	public void contextInitialized(ServletContextEvent sce) {
	
		// integrer des pizzas a la base de donnée au demmarage
			// méthode ajout 1
	Pizza pizza = new Pizza("FRO", "La 4 fromages", 12.00, CategoriePizza.SANS_VIANDE,"Pizza_4fromages.jpg");
	stockagePizza.save(pizza);
			// méthode ajout 2
	stockagePizza.save(new Pizza("REI", "La Reine", 11.50, CategoriePizza.VIANDE,"Pizza_Reine.jpg"));
	stockagePizza.save(new Pizza("REG", "La Regina", 13.00, CategoriePizza.VIANDE,"Pizza_Regina.jpg")); 

		//integrer des Clients a la base de donnée au demmarage
	stockageClient.save(new Client("Dupond", "Christophe", 100, "Christophe.D@gmail.fr", "Dupond"));
	stockageClient.save(new Client("Fritsh", "Franck", 150, "Franck.F@gmail.fr", "Fritsh"));
		//integrer des livreurs a la base de donnée au demmarage
	stockageLivreur.save(new Livreur("Speedy", "Gonzales", 1000, 500));
	stockageLivreur.save(new Livreur("Bepbep", "Coyote", 500, 700));
	}

	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		// TODO Auto-generated method stub
		
	}

}

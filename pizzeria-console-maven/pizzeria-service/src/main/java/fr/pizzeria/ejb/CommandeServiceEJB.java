package fr.pizzeria.ejb;

import java.util.Date;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import fr.pizzeria.model.Commande;
import fr.pizzeria.model.Pizza;


@Stateless
public class CommandeServiceEJB {
	
	@EJB private PizzaServiceEJB stockagePizza;
	@EJB private ClientServiceEJB stockageClient;
	@EJB private LivreurServiceEJB stockageLivreur;
	
	@PersistenceContext private EntityManager em ;
	
	
	public void save(Commande newElement) {

		em.persist(newElement); // créer le nouveau objet
	}

	@EJB private CommandeServiceEJB stockageCommande;
	@Schedule(second="1", minute="*", hour="*")
	public void insererCommande(){
		Date date = new Date();
		Set<Pizza> a = new HashSet<Pizza>();
		a.add(stockagePizza.find("FRO"));
		stockageCommande.save(new Commande(stockageClient.find(1), stockageLivreur.find(2), (int) (Math.random() * (100-2)), date ,a));	
	}
}

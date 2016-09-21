package fr.pizzeria.ejb;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Pizza;

@Stateless
public class PizzaServiceEJB {

	@PersistenceContext private EntityManager em ; // la suite comme stockage pizzaJPA sans les entity manager



	public Collection<Pizza> findAll() {

		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p", Pizza.class);
		Collection<Pizza> pizzas = query.getResultList();

		return pizzas;
	}

	public Pizza find(String code) {

		TypedQuery<Pizza> query = em.createNamedQuery("Pizza.findByCode", Pizza.class).setParameter("codeP", code);  
		Pizza p = query.getSingleResult();
		return p;
	}

	public void save(Pizza newElement) {

		em.persist(newElement); // créer le nouveau objet
	
	}

	public void update(Pizza editPizza, String ancienCode) {



		TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p WHERE p.code =:codeP", Pizza.class);
		query.setParameter("codeP", ancienCode);

		Pizza p = query.getSingleResult();

		p.setCode(editPizza.getCode());
		p.setNom(editPizza.getNom());
		p.setPrix(editPizza.getPrix());
		p.setCat(editPizza.getCat());
		p.setUrl(editPizza.getUrl());

		em.merge(p); // modifier un objet existant
		
	}

	public void delete(String ancienCode) {

		// selectionne la pizza dans la bdd : 
		TypedQuery<Pizza> query = em.createQuery("select p from Pizza p where reference=:ancienCode", Pizza.class).setParameter("ancienCode",ancienCode );
		// récupérer la pizza
		Pizza p = query.getSingleResult();
	
		// supprimer pizza selection�e
		em.remove(p);
		// enregister sur le bdd
	
	}


}

package fr.pizzeria.service;

import java.sql.SQLException;
import java.util.Collection;

import javax.enterprise.context.ApplicationScoped;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Pizza;

//@StockageType 
//@ApplicationScoped // pour que le bean dure pendans de toute l'application et pas regénéré a chaque servlet

//@Component // pour que l'ors du scan des beans 
public class StockagePizzaJPA  implements Stockage<Pizza, String>{
	
private EntityManagerFactory emf;


public StockagePizzaJPA(){

        this.emf = Persistence.createEntityManagerFactory("pizzeria-unit");
}



@Override
public Collection<Pizza> findAll() {
	
	
	
	EntityManager em = emf.createEntityManager();
	TypedQuery<Pizza> query = em.createQuery("select p from Pizza p", Pizza.class);
	Collection<Pizza> pizzas = query.getResultList();
	em.close();// fermer l'entitymanager apres la requete
	
	return pizzas;
}

@Override
public Pizza find(String code) {
	
	EntityManager em = emf.createEntityManager();
    TypedQuery<Pizza> query = em.createNamedQuery("pizza.findByCode", Pizza.class).setParameter("codeP", code);
    //TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p WHERE p.code =:codeP", Pizza.class).setParameter("codeP", code);
    
    Pizza p = query.getSingleResult();
    em.close();
    
    return p;
}

@Override
public void save(Pizza newElement) {
	
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	et.begin();
	
	em.persist(newElement);
	et.commit();
	em.close();
	
	
}

/* mon bazard a moi
@Override
public void update(Pizza editElement, String code) {
	EntityManager em = emf.createEntityManager();
	// selectionne la pizza dans la bdd : 
	TypedQuery<Pizza> query = em.createQuery("select p from Pizza p where reference=:ancienCode", Pizza.class).setParameter("code",code );
	// r�cup�rer la pizza
	Pizza p = query.getSingleResult();
	// ouvrir une transaction
	EntityTransaction et = em.getTransaction();
	et.begin();
	// modifier pizza selection�e
	em.merge(p.getCode());
	em.merge(p)p.getNom(),p.getPrix(),p.getCat());
	// enregister sur le bdd
	et.commit();
	//fermer la transaction
	em.close();
	
}
*/

@Override
public void update(Pizza editPizza, String ancienCode) {

    EntityManager em = emf.createEntityManager();
    EntityTransaction et = em.getTransaction();
    et.begin();

    TypedQuery<Pizza> query = em.createQuery("SELECT p FROM Pizza p WHERE p.code =:codeP", Pizza.class);
    query.setParameter("codeP", ancienCode);
    
    Pizza p = query.getSingleResult();

    p.setCode(editPizza.getCode());
    p.setNom(editPizza.getNom());
    p.setPrix(editPizza.getPrix());
    p.setCat(editPizza.getCat());
    p.setUrl(editPizza.getUrl());
    
    em.merge(p);
    
    et.commit();
    em.close();
}

@Override
public void delete(String ancienCode) {
	EntityManager em = emf.createEntityManager();
	// selectionne la pizza dans la bdd : 
	TypedQuery<Pizza> query = em.createQuery("select p from Pizza p where reference=:ancienCode", Pizza.class).setParameter("ancienCode",ancienCode );
	// récupérer la pizza
	Pizza p = query.getSingleResult();
	// ouvrir une transaction
	EntityTransaction et = em.getTransaction();
	et.begin();
	// supprimer pizza selection�e
	em.remove(p);
	// enregister sur le bdd
	et.commit();
	//fermer la transaction
	em.close();
	
}

}

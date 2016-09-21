package fr.pizzeria.ejb;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Client;
import fr.pizzeria.model.Livreur;

@Stateless
public class LivreurServiceEJB {
	@PersistenceContext private EntityManager em;

	public void save(Livreur newElement){
		em.persist(newElement); // créer le nouveau objet
		
	}
	
	public Collection<Livreur> findAll() {

		TypedQuery<Livreur> query = em.createQuery("SELECT l FROM Livreur l", Livreur.class);
		Collection<Livreur> livreurs = query.getResultList();

		return livreurs;
	}

	public Livreur find(Integer i) {

		TypedQuery<Livreur> query = em.createNamedQuery("Livreur.findByCode", Livreur.class).setParameter("codeL", i);  
		Livreur l = query.getSingleResult();
		return l;
	}

	

	public void update(Livreur editLivreur, String ancienCode) {

		TypedQuery<Livreur> query = em.createQuery("SELECT l FROM Livreur l WHERE l.code =:codeL", Livreur.class);
		query.setParameter("codeC", ancienCode);

		Livreur l = query.getSingleResult();

		l.setNom(editLivreur.getNom());
		l.setPrenom(editLivreur.getPrenom());
		l.setSolde(editLivreur.getSolde());
		l.setMontantDecouvertAutorise(editLivreur.getMontantDecouvertAutorise());
		
		em.merge(l); // modifier un objet existant
		
	}

	public void delete(String ancienCode) {

		// selectionne le livreur dans la bdd : 
		TypedQuery<Livreur> query = em.createQuery("SELECT l FROM Livreur l WHERE l.code =:codeL", Livreur.class).setParameter("ancienCode",ancienCode );
		// récupérer le livreur
		Livreur l = query.getSingleResult();
	
		// supprimer livreur selection�e
		em.remove(l);
		// enregister sur le bdd
	
	}

}

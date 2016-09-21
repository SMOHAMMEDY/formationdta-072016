package fr.pizzeria.ejb;

import java.util.Collection;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import fr.pizzeria.model.Client;
import fr.pizzeria.model.Pizza;

@Stateless
public class ClientServiceEJB {
	
	@PersistenceContext private EntityManager em;
	
	public void save(Client newElement){
		em.persist(newElement); // créer le nouveau objet
	}
	
	
	public Collection<Client> findAll() {

		TypedQuery<Client> query = em.createQuery("SELECT c from Client c", Client.class);
		Collection<Client> clients = query.getResultList();

		return clients;
	}
	
	
	public Client find(int i) {

		TypedQuery<Client> query = em.createNamedQuery("Client.findByCode", Client.class).setParameter("codeC", i);  
		Client c = query.getSingleResult();
		return c;
	}

	

	public void update(Client editClient, String ancienCode) {



		TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c WHERE c.code =:codeC", Client.class);
		query.setParameter("codeC", ancienCode);

		Client c = query.getSingleResult();

		c.setNom(editClient.getNom());
		c.setPrenom(editClient.getPrenom());
		c.setSolde(editClient.getSolde());
		c.setMail(editClient.getMail());
		c.setMdp(editClient.getMdp());

		em.merge(c); // modifier un objet existant
		
	}

	public void delete(String ancienCode) {

		// selectionne le client dans la bdd : 
		TypedQuery<Client> query = em.createQuery("SELECT c FROM Client c WHERE c.code =:codeC", Client.class).setParameter("ancienCode",ancienCode );
		// récupérer le client
		Client c = query.getSingleResult();
	
		// supprimer pizza selection�e
		em.remove(c);
		// enregister sur le bdd
	
	}

}

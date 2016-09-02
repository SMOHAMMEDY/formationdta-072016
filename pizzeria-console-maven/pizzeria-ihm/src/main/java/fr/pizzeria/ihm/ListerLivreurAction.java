package fr.pizzeria.ihm;

import java.util.Collection;

import fr.pizzeria.model.Livreur;


public class ListerLivreurAction extends Action {

	public ListerLivreurAction(IhmHelper helper) {
		super("Lister les Livreurs", helper);
	}

	public void execute() {
		System.out.println("**** Liste des livreurs ****");
		Collection<Livreur> livreurs = this.helper.getStockageLivreur().findAll();
		for (Livreur clientEnCours : livreurs ) {
			
			System.out.println(clientEnCours.toString());
		}
		System.out.println("\n");
	}

}

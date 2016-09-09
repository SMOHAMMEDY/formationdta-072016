package fr.pizzeria.ihm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Collectors;

import fr.pizzeria.model.Client;
import fr.pizzeria.model.CompteStat;
import fr.pizzeria.model.Livreur;

public class AfficherCompteStatAction extends Action {

	public AfficherCompteStatAction(IhmHelper helper) {
		super("Afficher les statistiques", helper);
	}

	public void execute() {
		int nbComptes = 0;
		double totalSolde = 0;
		double moySolde;
		double minSolde = 0;
		double maxSolde = 0;
		
		boolean isFirstOf = true; // est le premier de la liste
		
		System.out.println("**** Statistiques ****");
		
		// on récupère les listes de clients et de livreurs pour les statistiques
		Collection<Client> clients = this.helper.getStockageClient().findAll();
		Collection<Livreur> livreurs = this.helper.getStockageLivreur().findAll();
		
		Collection<CompteStat> personne = new ArrayList<CompteStat>();	// création de la liste de CompteStat
		personne.addAll(clients);	// on ajoute tous les clients à la liste personne
		personne.addAll(livreurs);	// on ajoute tous les livreurs à la liste personne
		
		
		///*************/////// EN JAVA 7 ///////**************/////
		
		
		// on parcourt la liste de personnes pour calculer toutes les statistiques
		for (CompteStat personneEnCours : personne ) {
			totalSolde +=  personneEnCours.getSolde(); // on ajoute le solde du personneEnCours au total
			
			// on différencie les traitements entre le premier de la liste et le reste
			// le solde du premier initialise le min et max
			// pour le reste, on compare le solde en cours avec les min et max
			if (isFirstOf){
				minSolde = personneEnCours.getSolde();
				maxSolde = personneEnCours.getSolde();
				isFirstOf = false;
			}
			else { 
				if(compareTo(personneEnCours, maxSolde) == 1){
					maxSolde = personneEnCours.getSolde();
				}
				if(compareTo(personneEnCours, minSolde) == -1){
					minSolde = personneEnCours.getSolde();
				}
			}
		}
		// à la fin du parcourt, on  récupère la taille de la liste et on calcule la moyenne
				nbComptes = personne.size();
				moySolde = totalSolde / nbComptes;
		
		/////// *********** ////////////En JAVA 8///////// *************////////
		
							
		double moySolde2 = personne.stream().collect(Collectors.averagingDouble(CompteStat::getSolde));
		
		double totalSold2 = personne.stream().map(t->t.getSolde()).reduce((t1, t2) -> t1 + t2 ).get();
		
		int nbComptes2 = (int) personne.stream().count();
		
		// on commence par le nom de la collection.stream 
		// on choisi un des 3 opérateur  .map / .filter / reduction (.collect(collectors.??? )
		// CTRL 1 pour ajouter la variable optional ( statement to new local variable )
		
		Optional<CompteStat> collect = personne.stream().collect(Collectors.minBy(Comparator.comparing(CompteStat::getSolde)));
		double minSolde2 = collect.get().getSolde();

		Optional<CompteStat> collect2 = personne.stream().collect(Collectors.maxBy(Comparator.comparing(CompteStat::getSolde)));
		
		double maxSolde2 = collect2.get().getSolde();
		
		
		
		// on affiche les statistiques !!!
		System.out.println("Nombre de comptes = " + nbComptes);
		System.out.println("Nombre de comptes lumbda = " + nbComptes2);
		System.out.println("Total solde = " + totalSolde + " €");
		System.out.println("Total solde lambda = " + totalSold2 + " €");
		System.out.println("Moyenne solde = " + moySolde + " €");
		System.out.println("Moyenne solde lambda = " + moySolde2 + " €");
		System.out.println("Solde le plus faible = " + minSolde + " €");
		System.out.println("Solde le plus faible lumbda = " + minSolde2 + " €");
		System.out.println("Solde le plus élevé = " + maxSolde + " €");
		System.out.println("Solde le plus élevé = lumbda " + maxSolde2 + " €");
		
	}

	public int compareTo(CompteStat p1, double solde){
		if(p1.getSolde() > solde){
			return 1;
		}
		else if(p1.getSolde() < solde){
			return -1;
		}
		else {
			return 0;
		}
	}
}

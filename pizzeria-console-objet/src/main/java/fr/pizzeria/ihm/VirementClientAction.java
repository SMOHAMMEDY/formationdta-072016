package fr.pizzeria.ihm;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.DebitException;

public class VirementClientAction extends Action {


	public VirementClientAction(IhmHelper helper) {
		super("Virement entre deux comptes client", helper);
	}

	@Override
	public void execute() {

		System.out.println("Vous voulez faire un virement entre deux comptes client");
		// introduire le code du client � d�biter
		System.out.println("Saisissez le code client � d�biter");
		Integer codeDeb = helper.getScanner().nextInt();
		// introduire le code du client � cr�diter
		System.out.println("Saisissez le code client � cr�diter");
		Integer codeCre = helper.getScanner().nextInt();
		
		// saisi du montant � cr�diter
		System.out.println("Veuillez saisir le montant � virer.");
		double montant = helper.getScanner().nextDouble();
		
		// d�biter le compte du client choisi par le montant saisi
		try {
			helper.getStockageClient().find(codeDeb).debiterCompte(montant);
			// cr�diter le compte du client choisi par le montant saisi
			try {
				helper.getStockageClient().find(codeCre).crediterCompte(montant);
				System.out.println("Virement effectu� !");
		/////		//
				System.out.println("le nouveau solde du Client " + helper.getStockageClient().find(codeCre).getNom() + helper.getStockageClient().find(codeCre).getPrenom() + " est de " +helper.getStockageClient().find(codeCre).getSolde() + " �");
		/////		//
			} catch (CreditException e1) {
				System.err.println(e1.getMessage());
				// si l'action cr�diter �choue, on recr�dite le compte d�biteur
				try {
					helper.getStockageClient().find(codeDeb).crediterCompte(montant);
				} catch (CreditException e2) {
					System.err.println(e2.getMessage());
				}
			}
		} catch (DebitException e3) {
			System.err.println(e3.getMessage());
		}

	}

}

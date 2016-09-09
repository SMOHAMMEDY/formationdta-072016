package fr.pizzeria.ihm;

import fr.pizzeria.exception.CreditException;

public class CrediterClientAction extends Action {


	public CrediterClientAction(IhmHelper helper) {
		super("Crediter un compte client", helper);
	}

	@Override
	public void execute() {

		// introduire le code du client � cr�diter
		System.out.println("Vous voulez modifier un solde de client veuillez choisir lequel (Code)");
		Integer code = helper.getScanner().nextInt();
		
		// saisi du montant � cr�diter
		System.out.println("Veuillez saisir le montant � cr�diter.");
		double montant = helper.getScanner().nextDouble();
		
		// cr�diter le compte du client choisi par le montant saisi
		
		try {
			helper.getStockageClient().find(code).crediterCompte(montant);
		} catch (CreditException e) {
			System.err.println(e.getMessage());
		}

	}

}

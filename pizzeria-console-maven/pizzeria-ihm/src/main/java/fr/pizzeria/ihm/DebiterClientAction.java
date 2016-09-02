package fr.pizzeria.ihm;

import fr.pizzeria.exception.DebitException;

public class DebiterClientAction extends Action{

	public DebiterClientAction(IhmHelper helper) {
		super("Débiter un compte client", helper);
	}

	@Override
	public void execute() {

		// introduire le code du client à créditer
		System.out.println("Vous voulez modifier un solde de client veuillez choisir lequel (Code)");
		Integer code = helper.getScanner().nextInt();
		
		// saisi du montant à créditer
		System.out.println("Veuillez saisir le montant à débiter.");
		double montant = helper.getScanner().nextDouble();
		
		// créditer le compte du client choisi par le montant saisi
		
		try {
			helper.getStockageClient().find(code).debiterCompte(montant);
		} catch (DebitException e) {
			System.err.println(e.getMessage() + "\n Solde client : " + helper.getStockageClient().find(code).getSolde());
		}

	}

}

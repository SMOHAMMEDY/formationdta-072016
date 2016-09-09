package fr.pizzeria.ihm;

import fr.pizzeria.model.Client;

public class AjouterClientAction extends Action {

	public AjouterClientAction(IhmHelper helper) {
		super("Ajouter un client", helper);
	}

	@Override
	public void execute() {

		// récuperation de la saisie
		System.out.println("Vous voulez ajoutez un client");
		System.out.println("Veuillez saisir le code");
		int code = helper.getScanner().nextInt();
		System.out.println("Veuillez saisir le nom du client");
		String nom = helper.getScanner().next();
		System.out.println("Veuillez saisir le prénom du client");
		String prenom = helper.getScanner().next();
		System.out.println("Veuillez saisir le solde initial du client");
		double solde = helper.getScanner().nextDouble();
		System.out.println("Veuillez saisir l'e-Mail du client");
		String mail = helper.getScanner().next();
		System.out.println("Veuillez saisir le Mdp du client");
		String mdp = helper.getScanner().next();
		
		// creation du nouveau client
		Client nouveauClient = new Client(code, nom, prenom, solde, mail, mdp);
		helper.getStockageClient().save(nouveauClient);

		System.out.println("Client ajouté avec succes" + "\n");

	}

}

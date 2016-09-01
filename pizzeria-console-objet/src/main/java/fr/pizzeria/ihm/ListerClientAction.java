package fr.pizzeria.ihm;

import java.util.Collection;

import fr.pizzeria.model.Client;


public class ListerClientAction extends Action {

	public ListerClientAction(IhmHelper helper) {
		super("Lister les Clients", helper);
	}

	public void execute() {
		System.out.println("**** Liste des clients ****");
		Collection<Client> clients = this.helper.getStockageClient().findAll();
				
		////java 7 
		
		for (Client clientEnCours : clients ) {
			
			System.out.println(clientEnCours);
		}
		System.out.println("\n");
		
	///// Java8
			clients.forEach(p -> System.out.println(p));
				// ou bien 
			clients.forEach(System.out::println);
	}

}

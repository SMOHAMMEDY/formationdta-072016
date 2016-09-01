package fr.pizzeria.ihm;

import java.util.Scanner;

import fr.pizzeria.exception.SaisieEntierException;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

public class IhmHelper {

	private Stockage<Pizza, String> stockagePizza;
	private Stockage<Client, Integer> stockageClient;
	private Stockage<Livreur, Integer> stockageLivreur;
	
	private Scanner scanner;

	public IhmHelper(Stockage<Pizza, String> stockage, Stockage<Client, Integer> stockageC,Stockage<Livreur, Integer> stockageL, Scanner scanner) {
		super();
		this.stockagePizza = stockage;
		this.scanner = scanner;
		this.stockageClient =stockageC;
		this.stockageLivreur =stockageL;
		
	}

	public int saisirEntier() throws SaisieEntierException {
		try {
			String saisie = scanner.next();
			return Integer.parseInt(saisie);
		} catch (NumberFormatException e) {
			throw new SaisieEntierException(e);
		}
	}

	public Stockage<Pizza, String> getStockagePizza() {
		return stockagePizza;
	}

	public Stockage<Client, Integer> getStockageClient() {
		return stockageClient;
	}

	public Stockage<Livreur, Integer> getStockageLivreur() {
		return stockageLivreur;
	}

	public void setStockageLivreur(Stockage<Livreur, Integer> stockageLivreur) {
		this.stockageLivreur = stockageLivreur;
	}

	public Scanner getScanner() {
		return scanner;
	}

}

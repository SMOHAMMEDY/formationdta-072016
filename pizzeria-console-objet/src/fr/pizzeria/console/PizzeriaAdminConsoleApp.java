package fr.pizzeria.console;

import java.util.Scanner;

import fr.pizzeria.ihm.IhmHelper;
import fr.pizzeria.ihm.Menu;
import fr.pizzeria.model.Client;
import fr.pizzeria.model.Livreur;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockageClientMap;
import fr.pizzeria.service.StockageLivreurMap;
import fr.pizzeria.service.StockagePizzaFichier;
import fr.pizzeria.service.StockagePizzaMap;

public class PizzeriaAdminConsoleApp {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);

		// **************Stockage en memoir pas de fichier
	
		//Stockage<Pizza, String> stockagePizza = new StockagePizzaMap();
		
		
		//*****************pour le stockage fichier
		Stockage<Pizza, String> stockagePizza = new StockagePizzaFichier();
		
		Stockage<Client, Integer> stockageClient = new StockageClientMap();
		Stockage<Livreur, Integer> stockageLivreur = new StockageLivreurMap();

		IhmHelper helper = new IhmHelper(stockagePizza, stockageClient,stockageLivreur, scanner);

		// Afficher le Menu

		Menu listMenu = new Menu(helper);

		listMenu.start();

		scanner.close();

	}

}

/*

 
//Création chemin d'un fichier data/pizza/test.txt
Path cheminFichier = Paths.get("data","pizza","test.txt");

// Création d'un nouveau fichier
Files.createFile(cheminFichier);

// Ecriture dans le fichier data/pizza/test.txt de 2 lignes
Files.write(cheminFichier, Arrays.asList("ligne 1, Du texte...", "ligne 2 --- "));

// Parcourir les lignes d'un fichier
Files.lines(cheminFichier).forEach(System.out::println);

// parcourir le répertoire data/pizza
Files.list(Paths.get("data", "pizza")).forEach(p -> System.out.println(p.getFileName()));

*/
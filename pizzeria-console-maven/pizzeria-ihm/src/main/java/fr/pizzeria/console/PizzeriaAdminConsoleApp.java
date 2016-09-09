package fr.pizzeria.console;


import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.logging.Level;

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

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {

		// suprimer le bloc rouge  d’information Hibernate
		java.util.logging.Logger.getLogger("org.hibernate").setLevel(Level.SEVERE);



		// **************Stockage en memoir pas de fichier
		//Stockage<Pizza, String> stockagePizza = new StockagePizzaMap();
		//*****************pour le stockage fichier

		Scanner scanner = new Scanner(System.in);

		// lire le fichier properties srs/main/ressource de ihm

		//Stockage<Pizza, String> stockagePizzaFichier = new StockagePizzaFichier();
		//Stockage<Pizza, String> stockagePizzaMap = new StockagePizzaMap();

		// lecture des properties remplce les 2 lines juste en haut
		ResourceBundle bundle = ResourceBundle.getBundle("application");
		String classeStockagePizza = bundle.getString("pizza.service.Impl");
		System.out.println(classeStockagePizza);
		// crer une classe indiquer dans le fichier application.properties dans srs main ressources
		Class<?> classePizza = Class.forName(classeStockagePizza);
		Stockage<Pizza, String> stockagePizza = (Stockage<Pizza, String>) classePizza.newInstance();

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
//Créationtion chemin d'un fichier data/pizza/test.txt
Path cheminFichier = Paths.get("data","pizza","test.txt");

// Creation d'un nouveau fichier
Files.createFile(cheminFichier);

// Ecriture dans le fichier data/pizza/test.txt de 2 lignes
Files.write(cheminFichier, Arrays.asList("ligne 1, Du texte...", "ligne 2 --- "));

// Parcourir les lignes d'un fichier
Files.lines(cheminFichier).forEach(System.out::println);

// parcourir le repertoire data/pizza
Files.list(Paths.get("data", "pizza")).forEach(p -> System.out.println(p.getFileName()));

 */
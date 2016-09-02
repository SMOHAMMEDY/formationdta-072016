

import java.util.ResourceBundle;
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

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		// **************Stockage en memoir pas de fichier
		//Stockage<Pizza, String> stockagePizza = new StockagePizzaMap();
		//*****************pour le stockage fichier
		
		Scanner scanner = new Scanner(System.in);
		
		// lire le fichier properties srs/main/ressource de ihm
		
			ResourceBundle bundle = ResourceBundle.getBundle("application");
        
			String classeStockagePizza = bundle.getString("stockage.pizza");
        
			System.out.println(classeStockagePizza);
        // fin de la prtie tp 4 maven
        
        Class<? > classePizza = Class.forName(classeStockagePizza);

        Stockage<Pizza, String> stockage = (Stockage<Pizza, String>) classePizza.newInstance();
		
		Stockage<Pizza, String> stockagePizzaFichier = new StockagePizzaFichier();
		Stockage<Pizza, String> stockagePizzaMap = new StockagePizzaMap();
		Stockage<Client, Integer> stockageClient = new StockageClientMap();
		Stockage<Livreur, Integer> stockageLivreur = new StockageLivreurMap();
		
		IhmHelper helper = new IhmHelper(stockagePizzaFichier, stockageClient,stockageLivreur, scanner);

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
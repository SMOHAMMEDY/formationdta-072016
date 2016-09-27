package fr.pizzeria.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class StockagePizzaFichier implements Stockage<Pizza, String>{

	public Map<String, Pizza> pizzas = new TreeMap<>();
	
	public StockagePizzaFichier()  {
		// Recuperer le dossier ou il y a les pizzas
		Path path = Paths.get("data/pizza");
		
		// parcourir le repertoire data/pizza
		try {
			Files.list(path).forEach(fichier -> {
				try {
					// Parcourir les lignes d'un fichier
					// Recuperer les pizzas
					// Stocker dans la map
					Files.lines(fichier).forEach(line -> pizzas.put(stockerPizza(line).getCode(), stockerPizza(line))) ;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	private Pizza stockerPizza(String line) {
		String [] laBonLine = line.toString().split(";");
		Pizza pizzaCree = new Pizza(laBonLine[0],laBonLine[1], Double.valueOf(laBonLine[2]),CategoriePizza.valueOf(laBonLine[3]), laBonLine[4]);
		return pizzaCree;
	} 

	@Override
	public Collection<Pizza> findAll() {
		
		return pizzas.values();
	}

	@Override
	public Pizza find(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Pizza newElement) {

		// Cr�ation d'un nouveau fichier
		// Files.createFile(cheminFichier);
		pizzas.put(newElement.getCode(),newElement);
		try {
			Path path = Paths.get("data/pizza",newElement.getCode() + ".txt");
			Files.createFile(path);
			Files.write(path, Arrays.asList(newElement.toFormat()));
			// Ecriture dans le fichier data/pizza/test.txt de 2 lignes
			// Files.write(cheminFichier, Arrays.asList("ligne 1, Du texte...", "ligne 2 --- "));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	

	@Override
	public void update(Pizza editElement, String code) {
		// TODO Auto-generated method stub
	}

	@Override
	public void delete(String ancienCode) {
		// TODO Auto-generated method stub
	}


}

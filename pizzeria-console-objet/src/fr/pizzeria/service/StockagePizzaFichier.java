package fr.pizzeria.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collection;

import fr.pizzeria.model.Pizza;






public class StockagePizzaFichier implements Stockage<Pizza, String>{

	@Override
	public Collection<Pizza> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Pizza find(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Pizza newElement) {
	
		// Création d'un nouveau fichier
		// Files.createFile(cheminFichier);
		try {
			Path path = Paths.get("data/pizza",newElement.getCode() + ".txt");
			Files.createFile(path);
			
		// Ecriture dans le fichier data/pizza/test.txt de 2 lignes
		// Files.write(cheminFichier, Arrays.asList("ligne 1, Du texte...", "ligne 2 --- "));
						
				Files.write(path, Arrays.asList(newElement.getNom() + ";" + newElement.getPrix()));
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
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

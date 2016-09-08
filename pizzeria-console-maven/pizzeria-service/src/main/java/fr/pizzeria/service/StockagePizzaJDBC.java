package fr.pizzeria.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;

public class StockagePizzaJDBC implements Stockage<Pizza, String>{
	
	//public Map<String, Pizza> pizzas = new TreeMap<>();

public Connection creerConnection() throws SQLException{
		
		 
		// lecture des properties remplce les 2 lines juste en haut
	        ResourceBundle bundle = ResourceBundle.getBundle("JDBC");
	        String url = bundle.getString("url");
	        String user = bundle.getString("user");
	        String mdp = bundle.getString("MDP");
	        
		// création connection
	        Connection connection = DriverManager.getConnection(url,user,mdp);
	        return connection;
	}
	
	@Override
	public Collection<Pizza> findAll() {
		
		
		 Collection<Pizza> pizzas = new ArrayList<>();
		/* 
		// lecture des properties remplce les 2 lines juste en haut
	        ResourceBundle bundle = ResourceBundle.getBundle("JDBC");
	        String url = bundle.getString("url");
	        String user = bundle.getString("user");
	        String mdp = bundle.getString("MDP");
	    
	    // Créer une connection  structure : Connection connection = DriverManager.getConnection(url,user,password);
		
				//  ouverture des ressources connection statement  et resutat 
					Connection connection = DriverManager.getConnection(url,user,mdp);
									
			*/		
	        
		
		// Créer une connection  structure : Connection connection = DriverManager.getConnection(url,user,password);
		try{
			//  ouverture des ressources connection statement  et resutat 
				Connection connection = creerConnection();
	
		        Statement st = connection.createStatement();
		        
		        ResultSet resultat = st.executeQuery("select * from pizza");
		   
			
			
			while(resultat.next()){
				String code = resultat.getString("reference");
				String nom = resultat.getString("libelle");
				double prix = resultat.getDouble("prix");
				// récupéré le string de categories puis le convertir en type categorie pizza
				String cat = resultat.getString("categories");
				CategoriePizza catPizza = CategoriePizza.valueOf(cat);
				
				Pizza nPizza = new Pizza (code, nom, prix, catPizza);
		
				//pizzas.put(code, NPizza);
				pizzas.add(nPizza);
			}
			
		} catch (SQLException e) {
			
			throw new RuntimeException(e);
		}
		return pizzas;
	}

	@Override
	public Pizza find(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Pizza newElement) {

		
		Connection connection;
		try {
			String sqlInsert = "INSERT INTO pizza (reference,libelle,prix, categories) VALUES ( ?,?,?,?);"; // pour ajouter une pizza
			String sqlUpdate = "UPDATE pizza SET reference = ?, libelle = ? , prix = ? ,categories = ? WHERE id = ?;"; // pour modifier une pizza 
			connection = creerConnection();
			// Method 1 dialoger avec BDD INSERT, UPDATE, DELETE

			/*
			Statement st = connection.createStatement();
			String requete = "INSERT INTO PIZZA(reference,libelle,prix,categories) VALUES('" + newElement.getCode() +"','"+ newElement.getNom()+"',"+ newElement.getPrix()+",'"+newElement.getCat()+"')";
			int nbPizzaInsere =  st.executeUpdate(requete); 
			*/
			
			// Method 2 PreparedStatement
			PreparedStatement updatePizzaSt= connection.prepareStatement(sqlInsert); 
			updatePizzaSt.setString(1,newElement.getCode()); 
			updatePizzaSt.setString(2,newElement.getNom());
			updatePizzaSt.setDouble(3,newElement.getPrix());
			updatePizzaSt.setString(4,newElement.getCat().name());// .name pour transformer un objet de type ennumération en chain de caractère portant le nom 
			updatePizzaSt.executeUpdate(); 
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	return;
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

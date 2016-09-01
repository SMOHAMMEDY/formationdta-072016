package fr.pizzeria.service;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import fr.pizzeria.model.Livreur;


public class StockageLivreurMap implements Stockage <Livreur, Integer> {
	
	public Map<Integer, Livreur> livreur = new TreeMap<>();

	public StockageLivreurMap() {
		this.livreur.put(1, new Livreur(1,"Deer","Jhon", -200, -1000));
	

	}

    @Override
    public Collection<Livreur> findAll() {
        // TODO Auto-generated method stub
        return livreur.values();
    }

  
    public Livreur find(Integer code) {
        // TODO Auto-generated method stub
    	return livreur.get(code);
    	
    }
    @
    Override
    public void save(Livreur newClient) {
    	this.livreur.put(newClient.getCode(), newClient);
        
    }

    @Override
    public void update(Livreur editElement, Integer  code) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Integer ancienCode) {
        // TODO Auto-generated method stub
        
    }

}
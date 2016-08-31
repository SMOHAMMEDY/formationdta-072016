package fr.pizzeria.service;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

import fr.pizzeria.model.Client;


public class StockageClientMap implements Stockage <Client, Integer> {
	
	public Map<Integer, Client> client = new TreeMap<>();

	public StockageClientMap() {
		this.client.put(1, new Client(1,"thomas","Dupond", 120));
	

	}

    @Override
    public Collection<Client> findAll() {
        // TODO Auto-generated method stub
        return client.values();
    }

  
    public Client find(Integer code) {
        // TODO Auto-generated method stub
    	return client.get(code);
    	
    }
    @
    Override
    public void save(Client newClient) {
    	this.client.put(newClient.getCode(), newClient);
        
    }

    @Override
    public void update(Client editElement, Integer  code) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void delete(Integer ancienCode) {
        // TODO Auto-generated method stub
        
    }

}
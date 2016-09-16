  
package fr.pizzeria.admin.web;

import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockagePizzaJPA;


public class PersistanceUtils {
    
    private static PersistanceUtils instanceUnique = new PersistanceUtils();
    
    private Stockage<Pizza, String> stockagePizza = new StockagePizzaJPA();
    
    // etape 1 - constructeur privé
    private PersistanceUtils() {
    }
    
    // etape 2 - accéder à l'instance unique depuis l'extérieur de la classe
    public static PersistanceUtils getInstance() {
        return instanceUnique;
    }
    
    public Stockage<Pizza, String> getStockagePizza() {
        return stockagePizza;
    }
}
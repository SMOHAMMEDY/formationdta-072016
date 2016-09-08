package fr.pizzeria.model;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import fr.pizzeria.exception.CreditException;


public class ClientTest {

	@Test
	public void testCrediterCompte() throws CreditException {
		
		// créer une instance de client pour faire le test 
		Client client = new Client(99999, "nomTest", "prénomTest", 0);
		
		client.crediterCompte(10);
		
		Assert.assertTrue(client.getSolde()== 10);
		
		
	}
	
	@Test(expected = CreditException.class)
	
	public void testcréditCompte() {
	
	}

}

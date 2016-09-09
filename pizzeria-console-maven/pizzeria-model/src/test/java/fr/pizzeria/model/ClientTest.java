package fr.pizzeria.model;

import org.junit.Assert;
import org.junit.Test;

import fr.pizzeria.exception.CreditException;


public class ClientTest {

	@Test
	public void testCrediterCompte() throws CreditException {
		
		// cr�er une instance de client pour faire le test 
		Client client = new Client(99999, "nomTest", "pr�nomTest", 0, "blabla@gmail.com", "12345");
		
		client.crediterCompte(10);
		
		Assert.assertTrue(client.getSolde()== 10);
		
		
	}
	
	@Test(expected = CreditException.class)
	
	public void testcreditCompte() {
	
	}

}

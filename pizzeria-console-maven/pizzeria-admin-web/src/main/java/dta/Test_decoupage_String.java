package dta;

import fr.pizzeria.model.Pizza;

public class Test_decoupage_String {
	
	public static void main(String[] args) {
		String data = "code=ERR&nom=PEPERONI&prix=12";
		
		String[] split = data.split("&");
		
		for(String s : split) {
			
			String[] split2 = s.split("=");
			
			String cle = split2[0];
			String valeur = split2[1];
			
			System.out.println("cle=" + cle + " valeur = " + valeur);
	
			System.out.println("---");

		}
		
		
		
		Pizza p = new Pizza();
		
		
	}
	

}

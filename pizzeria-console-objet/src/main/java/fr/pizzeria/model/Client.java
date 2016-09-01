package fr.pizzeria.model;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.DebitException;

public class Client extends AbstractPersonne implements CompteStat{
	
	
	
public Client(Integer nouveauCode, String nouveauNom, String nouveauPrenom, double nouveauSolde){
	super(nouveauCode, nouveauNom, nouveauPrenom, nouveauSolde);
		
	}
	
	
	@Override
	public void  crediterCompte(double montant) throws CreditException{
		
		double nouveauSolde = this.solde + montant;
				
		if (nouveauSolde > 5000 ){
			throw new CreditException();
		}
	this.solde = nouveauSolde;
}
	
	@Override
	public void debiterCompte(double montant) throws DebitException{
		
		double nouveauSolde = this.solde - montant;
		
		if(nouveauSolde < 0){
			throw new DebitException();
		}
		this.solde = nouveauSolde;
		
	}
	
	
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	
	

}

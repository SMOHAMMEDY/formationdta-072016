package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.DebitException;

@Entity
public class Client extends AbstractPersonne implements CompteStat{

	@Column(name= "mot_de_passe")
	private String mdp;
	@Column(name= "e_Mail")
	private String mail;
	
	
public Client(Integer nouveauCode, String nouveauNom, String nouveauPrenom, double nouveauSolde, String nouveauEmail, String nouveauMdp){
	super(nouveauCode, nouveauNom, nouveauPrenom, nouveauSolde);
	this.mail = nouveauEmail;
	this.mdp = nouveauMdp;
	
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

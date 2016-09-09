package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.MappedSuperclass;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.DebitException;

@MappedSuperclass
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class AbstractPersonne {
	
	@Id @ GeneratedValue(strategy=GenerationType.IDENTITY) @Column(name= "id")
	protected Integer code;
	@Column(name= "nom", length = 30)
	protected  String nom;
	@Column(name= "prenom", length = 30)
	protected  String prenom;
	@Column(name= "solde", length = 5)
	protected  double solde;
	
	public AbstractPersonne(Integer code, String nom, String prenom, double solde) {
		super();
		this.code = code;
		this.nom = nom;
		this.prenom = prenom;
		this.solde = solde;
	}
	

	public void  crediterCompte(double montant) throws CreditException{
		
		double nouveauSolde = this.solde + montant;
		this.solde = nouveauSolde;
}
	
	
	public void debiterCompte(double montant) throws DebitException{
		
		double nouveauSolde = this.solde - montant;
		this.solde = nouveauSolde;
		
	}
	
	public String toString(){
		
		return this.getCode() + "-> " + this.getNom() + " " + this.getPrenom() +" (" + this.getSolde() + ")";
		
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

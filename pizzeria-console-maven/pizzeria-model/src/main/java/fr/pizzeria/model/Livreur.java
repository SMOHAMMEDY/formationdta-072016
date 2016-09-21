package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import fr.pizzeria.exception.DebitException;

@Entity
@NamedQuery(name="Livreur.findByCode", query="SELECT l FROM Livreur l WHERE l.code =:codeL")
public class Livreur extends AbstractPersonne implements CompteStat{

	@Column(name= "DecouverAutorise", length = 5)
	private double montantDecouvertAutorise;
	
	public double getMontantDecouvertAutorise() {
		return montantDecouvertAutorise;
	}


	public void setMontantDecouvertAutorise(double montantDecouvertAutorise) {
		this.montantDecouvertAutorise = montantDecouvertAutorise;
	}


	public Livreur(Integer code, String nom, String prenom, double solde, double montantDecouvertAutorise) {
		super(code, nom, prenom, solde);
		this.montantDecouvertAutorise = montantDecouvertAutorise;
		
	}


public Livreur() {
		super();
	}


// public void créditer est utiliser directement de AbstractPersonne car pas le limite pour le livreur
	


	@Override
	public void debiterCompte(double montant) throws DebitException{
		
		double nouveauSolde = this.solde - montant;
		
		if(nouveauSolde < this.montantDecouvertAutorise){
			throw new DebitException();
		}
		this.solde = nouveauSolde;
		
	}
	
	public Livreur(String nom, String prenom, double solde, double montantDecouvertAutorise) {
		super( nom, prenom, solde);
		this.montantDecouvertAutorise = montantDecouvertAutorise;
	}


	@Override
	public String toString(){
		
		return this.getCode() + "-> " + this.getNom() + " " + this.getPrenom() +" (" + this.getSolde() + ")" + " (montant découvert autorisé = " + this.getMontantDecouvertAutorise() + " )" ;
		
	}
	
}

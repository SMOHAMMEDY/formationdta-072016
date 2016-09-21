package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQuery;

import fr.pizzeria.exception.CreditException;
import fr.pizzeria.exception.DebitException;

@Entity
@NamedQuery(name="Client.findByCode", query="SELECT c FROM Client c WHERE c.code =:codeC")
public class Client extends AbstractPersonne implements CompteStat{

	@Column(name= "mot_de_passe")
	private String mdp;
	@Column(name= "e_Mail")
	private String mail;
	
	
    public String getMail() {
		return mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}

	public Client(Integer nouveauCode, String nouveauNom, String nouveauPrenom, double nouveauSolde, String nouveauEmail, String nouveauMdp){
	super(nouveauCode, nouveauNom, nouveauPrenom, nouveauSolde);
	this.mail = nouveauEmail;
	this.mdp = nouveauMdp;
	
	}

	public Client(String nom, String prenom, double solde, String mdp, String mail) {
		super( nom, prenom, solde);
		this.mdp = mdp;
		this.mail = mail;
	}
	

	public Client() {
		super();
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
	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
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

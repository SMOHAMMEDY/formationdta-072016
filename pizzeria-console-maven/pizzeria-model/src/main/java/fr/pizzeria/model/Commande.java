package fr.pizzeria.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Commande {

@Id @ GeneratedValue(strategy=GenerationType.IDENTITY)
private Integer id;
//relation commande client
@ManyToOne @JoinColumn (name= "client_id")
private Client client;
@ManyToOne@JoinColumn(name= "livreur_id")
private Livreur livreur;
@Column(name= "numero_commande", length = 20)
private Integer N_commande;
@Column(name= "date_commande", length = 10)
private Date date;

@ManyToMany @JoinTable(name="commande_pizza",
					joinColumns=
					@JoinColumn(name="id_commande", referencedColumnName="id"), // jointure faite a partir de commande on commence par commande car on est dans la classe commande
					inverseJoinColumns=
					@JoinColumn(name ="id_pizza", referencedColumnName="id") // puisque la jointure a partir de pizza est faite ici pas la peine de la faire sur pizza
					)
private Set<Pizza> pizza;


public Commande(Integer id, Client client, Livreur livreur, Integer n_commande, Date date, Set<Pizza> pizza) {
	super();
	this.id = id;
	this.client = client;
	this.livreur = livreur;
	N_commande = n_commande;
	this.date = date;
	this.pizza = pizza;

}
public Commande(Client client, Livreur livreur, Integer n_commande, Date date, Set<Pizza> pizza) {
	super();
	this.client = client;
	this.livreur = livreur;
	N_commande = n_commande;
	this.date = date;
	this.pizza = pizza;

}

public Commande() {
	super();
}





public Integer getId() {
	return id;
}
public void setId(Integer id) {
	this.id = id;
}
public Client getClient() {
	return client;
}
public void setClient(Client client) {
	this.client = client;
}
public Livreur getLivreur() {
	return livreur;
}
public void setLivreur(Livreur livreur) {
	this.livreur = livreur;
}
public Integer getN_commande() {
	return N_commande;
}
public void setN_commande(Integer n_commande) {
	N_commande = n_commande;
}
public Date getDate() {
	return date;
}
public void setDate(Date date) {
	this.date = date;
}



}

















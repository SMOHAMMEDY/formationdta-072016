package fr.pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.apache.commons.lang3.StringUtils;

@Entity
public class Pizza {

	private static int NbPizza;

	@Id @ GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id; // (strategy = GenerationType.EDENTITY) pour dire qu'il prend les valeurs g�n�r� dans ma table dans la base des donn�e
	@Column(name= "reference", length = 5, nullable = false, unique = true )
	private String code;
	@Column(name= "libelle", length = 30)
	private String nom;
	@Column(name= "prix", length = 10)
	private double prix;
	@ Enumerated(EnumType.STRING) @Column(name ="categories")
	private CategoriePizza cat;
	

	public Pizza(String code, String nom, double prix, CategoriePizza cat) {
		super();
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.cat = cat;
	}	


	public Pizza() {
		super();
	}


	@Override
	public String toString() {
		
		//String str = (this.code + "\t" + this.nom + "\t"  + this.prix + "\t" + this.cat);
		String str = StringUtils.rightPad(this.code, 5) + "\t" +  StringUtils.rightPad(this.nom, 20) + "\t" +  StringUtils.rightPad(String.valueOf(this.prix), 5) +  "\t" +  StringUtils.rightPad(this.cat.toString(), 5) ;
		return str;
	}


	public CategoriePizza getCat() {
		return cat;
	}

	public void setCat(CategoriePizza cat) {
		this.cat = cat;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}

	public String toFormat() {
		String str = (this.code + ";" + this.nom + ";"  + this.prix + ";" + this.cat);
		return str;
	}


	public static int getNbPizza() {
		return NbPizza;
	}


	public static void setNbPizza(int nbPizza) {
		NbPizza = nbPizza;
	}

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

}

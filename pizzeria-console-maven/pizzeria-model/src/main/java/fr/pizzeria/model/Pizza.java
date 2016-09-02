package fr.pizzeria.model;

public class Pizza {

	private static int NbPizza;

	private String code;
	private String nom;
	private double prix;
	private CategoriePizza cat;
	

	public Pizza(String code, String nom, double prix, CategoriePizza cat) {
		super();
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.cat = cat;
	}	


	@Override
	public String toString() {
		
		String str = (this.code + "\t" + this.nom + "\t"  + this.prix + "\t" + this.cat);
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

	

}

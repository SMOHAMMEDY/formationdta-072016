package dta;

import java.util.Collection;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import fr.pizzeria.model.CategoriePizza;
import fr.pizzeria.model.Pizza;
import fr.pizzeria.service.Stockage;

@Repository
public class StockagePizzaSpringJdbc implements Stockage<Pizza, String> {
	
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public StockagePizzaSpringJdbc(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
/*// Au depart le findall sans lumbda
	@Override
	public Collection<Pizza> findAll() {
		return this.jdbcTemplate.query("select * from pizza", new RowMapper<Pizza>(){

			@Override
			public Pizza mapRow(ResultSet resultat, int rowNum) throws SQLException {
				Pizza pizza =new Pizza();
				pizza.setCode(resultat.getString("reference"));
				pizza.setNom(resultat.getString("libelle"));
				pizza.setPrix(resultat.getDouble("prix"));
				pizza.setCat(CategoriePizza.valueOf(resultat.getString("categories")));
				
				return pizza;
			}
			
		});
	}
	
	
	// premiere simplification Lumbda
	@Override
	public Collection<Pizza> findAlllumbda() {
		return this.jdbcTemplate.query("select * from pizza",
				(ResultSet resultat, int rowNum) ->{
				Pizza pizza =new Pizza();
				pizza.setCode(resultat.getString("reference"));
				pizza.setNom(resultat.getString("libelle"));
				pizza.setPrix(resultat.getDouble("prix"));
				pizza.setCat(CategoriePizza.valueOf(resultat.getString("categories")));
				
				return pizza;
			});
	}
	*/
	
	
	// 2éme simplification 
	  //remplacer tout el pavé par une variable
	
	private RowMapper<Pizza> pizza = (resultat,rowNum) ->{
		Pizza pizza =new Pizza();
		pizza.setId(resultat.getInt("Id"));
		pizza.setCode(resultat.getString("reference"));
		pizza.setNom(resultat.getString("libelle"));
		pizza.setPrix(resultat.getDouble("prix"));
		pizza.setCat(CategoriePizza.valueOf(resultat.getString("categories")));
		pizza.setUrl(resultat.getString("Url_Image"));
		
		return pizza;
	};
	/*
	public Collection<Pizza> findAllLumbdaChamp() {
		return this.jdbcTemplate.query("select * from pizza", pizza);
	}
	*/
	
	// 3éme simplification le find alla avec la lumbda la plus simplifier
	public Collection<Pizza> findAll() {
	 String sql = "select * from pizza";
	 return this.jdbcTemplate.query(sql, pizza);
	}


	@Override
	public Pizza find(String code) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public void save (Pizza p) { 
		String sql = "INSERT INTO pizza (reference,libelle,prix, categories) VALUES ( ?,?,?,?)"; 
		this.jdbcTemplate.update(sql, p.getCode(), p.getNom(), p.getPrix(), p.getCat());
		}



	@Override
	public void update(Pizza editElement, String code) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(String ancienCode) {
		// TODO Auto-generated method stub
		
	}


	public void insererParLot(List<Pizza> pizzas) {
		
		
	}


}

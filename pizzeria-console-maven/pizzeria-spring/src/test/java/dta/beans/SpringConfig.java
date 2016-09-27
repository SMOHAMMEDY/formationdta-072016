package dta.beans;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import fr.pizzeria.service.Stockage;
import fr.pizzeria.service.StockagePizzaJPA;

@Configuration   // configuration avec java //@configuration pour dire que c'est un beans de configuration
@ComponentScan({"dta"/*, "fr.pizzeria.service" remplacer par une configuration java*/}) // ou je cherche mes autre beans ....parcourir les packages ou j'ai mis l'annotation compenantes
public class SpringConfig {

	//la configuration en java qui remplace est:
	@Bean
	public Stockage<?,?> stockage(){
		return new StockagePizzaJPA();
	}
	// fin de la config java qui remplace la dependance de spring dans la partie service et le lien  vers elle dans le @ compenantScann
	
	// création de bean datasource // voir le persistance.xml
	@Bean // n'importe ou dans mon code si je met @autowired j'ai ma datasource
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/pizzeriajpa?useSSL=false");
        dataSource.setUsername("root");
        dataSource.setPassword("");
        return dataSource;
    }
}

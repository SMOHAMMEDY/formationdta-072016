package springMvc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalEntityManagerFactoryBean;
import org.springframework.orm.jpa.support.PersistenceAnnotationBeanPostProcessor;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@EnableJpaRepositories("springMvc")
@ComponentScan("springMvc , dta")
@EnableTransactionManagement
public class PizzeriaSpringConfig {
	

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
	// activer JPA et lire le fichier META-INF/persistence.xml
	 @Bean
	 public LocalEntityManagerFactoryBean entityManagerFactory() {
	     LocalEntityManagerFactoryBean emf = new LocalEntityManagerFactoryBean();
	     emf.setPersistenceUnitName("pizzeria-unit");
	     return emf;
	 }
	// pouvoir utiliser les annotations JPA (@PersistenceContext)
	 @Bean
	 public PersistenceAnnotationBeanPostProcessor persistenceAnn() {
	     return new  PersistenceAnnotationBeanPostProcessor();
	 }
	 
	 // configuration du gestionnaire de transaction
	 @Bean
	 public PlatformTransactionManager transactionManager(DataSource dataSource) {
	     return new JpaTransactionManager();
	 }


}

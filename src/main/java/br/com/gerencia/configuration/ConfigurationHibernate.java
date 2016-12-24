package br.com.gerencia.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.hibernate4.HibernateTransactionManager;
import org.springframework.orm.hibernate4.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@ComponentScan({ "br.com.gerencia.configuration" })
@PropertySource(value = { "classpath:application.properties" })
public class ConfigurationHibernate {
	@Autowired
	private Environment environment;

	
	@Bean
	public LocalSessionFactoryBean sessionFactory( ) {

		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "br.com.gerencia.model" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
//	@Autowired
//	DataSource dataSource;
//
//	@Bean
//	public JdbcTemplate getJdbcTemplate() {
//		return new JdbcTemplate(dataSource);
//	}
//	https://www.mkyong.com/spring/spring-embedded-database-examples/
	@Bean
	public DataSource dataSource() {
//		EmbeddedDatabaseBuilder builder = new EmbeddedDatabaseBuilder();
//		EmbeddedDatabase db = builder
//			.setType(EmbeddedDatabaseType.HSQL) //.H2 or .DERBY
//			.addScript("db/sql/create-db.sql")
//			.addScript("db/sql/insert-data.sql")
//			.build();
		JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
		dsLookup.setResourceRef(true);
		DataSource dataSource = dsLookup.getDataSource("java:/gerencia");
		//DataSource dataSource = dsLookup.getDataSource("java:/teste");
	

//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName(environment
//				.getRequiredProperty("jdbc.driverClassName"));
//		dataSource.setUrl(environment.getRequiredProperty("jdbc.url"));
//		dataSource
//				.setUsername(environment.getRequiredProperty("jdbc.username"));
//		dataSource
//				.setPassword(environment.getRequiredProperty("jdbc.password"));
		return dataSource;
	}

	@Bean
	public Properties hibernateProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect",
				environment.getRequiredProperty("hibernate.dialect"));
//		properties.put("hibernate.show_sql",
//				environment.getRequiredProperty("hibernate.show_sql"));
		properties.put("hibernate.format_sql",
				environment.getRequiredProperty("hibernate.format_sql"));
		properties.put("hibernate.hbm2ddl.auto", environment.getRequiredProperty("hibernate.hbm2ddl.auto"));
		
	
		return properties;
	}


	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory s) {
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(s);
		return txManager;
	}
}

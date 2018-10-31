package com.pra.DBConfiguration;

import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;


@Configuration
@ComponentScan(basePackages={"com.pra.model"})
@EnableTransactionManagement

public class DBConfiguration 
{
	public DBConfiguration() 
	{
		System.out.println("configurtion bean is created.");
		
	}
	
	@Bean(name="dataSource")
	public DataSource getDataSource() 
	{
		System.out.println("Entering Database bean is created");
		BasicDataSource dataSource=new BasicDataSource();
		System.out.println("fel1");
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		System.out.println("Datasource bean is"+dataSource);
		return dataSource;

	}
	
	@Bean
	public SessionFactory sessionFactory() {
		System.out.println("Entering Sessionfactory creation method");
		LocalSessionFactoryBuilder lsfb=new LocalSessionFactoryBuilder(getDataSource());
		//System.out.println("hi1");
		Properties hibernateProperties=new Properties();
		//System.out.println("hi2");
		hibernateProperties.put("hibernate.dialect","org.hibernate.dialect.H2Dialect");
		//System.out.println("hi3");
		hibernateProperties.put("hibernate.hbm2dd1.auto","update");
		hibernateProperties.put("hibernate.show_sql","true");
		hibernateProperties.put("hibernate.format_sql","true");
		
		 lsfb.addProperties(hibernateProperties);
		 lsfb.scanPackages("com.pra.model");
		/*lsfb.addProperties(hibernateProperties);
		lsfb.scanPackages("com.pra.model");*/
		
		return lsfb.buildSessionFactory();		
		
		//Class classes[]=new Class[] {};
		//return lsfb.addAnnotatedClasses(classes).buildSessionFactory();
		

	}
	
	/*private Properties getHibernateProperties() {
		
		Properties properties = new Properties();
		//properties.put("hibernate.dialect", DATABASE_DIALECT);		
		properties.put("hibernate.show_sql", "true");
		properties.put("hibernate.format_sql", "true");
		properties.put("hibernate.hbm2ddl.auto", "update");//create - drop existing table and recreate new one
		//u want to store table-if database table not there it will create new one 
		
		return properties;
	}*/
	
	@Bean
	public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) 
	{
		return new HibernateTransactionManager(sessionFactory); 
	}
}
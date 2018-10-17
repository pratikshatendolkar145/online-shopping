package com.pra.DBConfiguration;

import java.util.Properties;
import javax.sql.DataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;

@Configuration
public class DBConfiguration 
{
	public DBConfiguration()
	{
		System.out.println("Database Configuration bean is created");
	}
	
	@Bean
	public DataSource getDataSource()
	{
		System.out.println("Entering Database bean is created");
		BasicDataSource dataSource=new BasicDataSource();
		dataSource.setDriverClassName("org.h2.Driver");
		dataSource.setUrl("jdbc:h2:tcp://localhost/~/test");
		dataSource.setUsername("sa");
		dataSource.setPassword("");
		
		System.out.println("Datasource bean is"+dataSource);
		return dataSource;
			
	}
	
	@Bean
	public SessionFactory sessionfactory()
	{
		System.out.println("Entering Sessionfactory creation method");
		LocalSessionFactoryBuilder lsfb=new LocalSessionFactoryBuilder((javax.sql.DataSource) getDataSource());
		Properties hibernateProperties=new Properties();
		hibernateProperties.setProperty("hibernate Dialect","org.hibernate.dialect.H2Dialect");
		hibernateProperties.setProperty("hibernate.hbm2dd1.auto","update");
		hibernateProperties.setProperty("hibernate.show_sql","true");
		lsfb.addProperties(hibernateProperties);
		Class classes[]=new Class[] {};
		
		System.out.println("SessionFactory bean"+lsfb);
		return lsfb.addAnnotatedClasses(classes).buildSessionFactory();
		
	}
	
	public HibernateTransactionManager hibernateTransactionManager()
	{
		return new HibernateTransactionManager(sessionfactory());
	}
	


}

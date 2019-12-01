package com.jay.easyshop.databaseservice.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration {

	@Autowired
	DataSource dataSource;
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
	    LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
	    sessionFactoryBean.setDataSource(this.dataSource);
	    sessionFactoryBean.setPackagesToScan(new String[] { "com.jay.easyshop" });
	    sessionFactoryBean.setHibernateProperties(getHibernateProperties());
	    return sessionFactoryBean;
	}
	
	 @Bean
	 public HibernateTransactionManager transactionManager() {
	    HibernateTransactionManager transactionManager = 
	        new HibernateTransactionManager();
	    transactionManager.setSessionFactory(sessionFactory().getObject());
	    return transactionManager;
	}
	 
	public Properties getHibernateProperties()
	{
		 Properties hibernateProperties = new Properties();
		 hibernateProperties.put("hibernate.current_session_context_class","org.springframework.orm.hibernate5.SpringSessionContext");
		 hibernateProperties.put("hibernate.dialect","org.hibernate.dialect.MySQL5Dialect");
		 hibernateProperties.put("hibernate.hbm2ddl.auto", "update");
		 hibernateProperties.put("hibernate.show_sql", true);
		 return hibernateProperties;
	} 
}

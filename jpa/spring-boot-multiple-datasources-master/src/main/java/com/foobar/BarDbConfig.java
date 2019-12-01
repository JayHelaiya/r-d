package com.foobar;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
					   entityManagerFactoryRef = "barEntityManagerFactory",
    				   transactionManagerRef = "barTransactionManager", 
    				   basePackages = {"com.foobar.bar.repo"}
					   )
public class BarDbConfig {

  @Bean(name = "barDataSource")
  @ConfigurationProperties(prefix = "bar.datasource")
  public DataSource dataSource() {
    return DataSourceBuilder.create().build();
  }

  @Bean(name = "barEntityManagerFactory")
  public LocalContainerEntityManagerFactoryBean barEntityManagerFactory(
      EntityManagerFactoryBuilder builder, 
      @Qualifier("barDataSource") DataSource dataSource) {

	  	 LocalContainerEntityManagerFactoryBean em = builder.dataSource(dataSource).build();
	     em.setDataSource(dataSource());
	     em.setPackagesToScan(new String[] { "com.foobar.bar.domain" });
	     JpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
	     em.setJpaVendorAdapter(vendorAdapter);
	     em.setJpaProperties(additionalProperties());
	     return em;
  }
  
  @Bean(name = "barTransactionManager")
  public PlatformTransactionManager barTransactionManager(
      @Qualifier("barEntityManagerFactory") EntityManagerFactory barEntityManagerFactory) {
	  JpaTransactionManager transactionManager = new JpaTransactionManager();
      transactionManager.setEntityManagerFactory(barEntityManagerFactory);
      return transactionManager;
  }
  
  @Bean
  public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
      return new PersistenceExceptionTranslationPostProcessor();
  }
   
  Properties additionalProperties() {
      Properties properties = new Properties();
      properties.setProperty("hibernate.hbm2ddl.auto", "update");
      properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
      return properties;
  }
  
}

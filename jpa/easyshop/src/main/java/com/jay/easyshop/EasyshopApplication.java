package com.jay.easyshop;

import java.io.File;

import org.apache.log4j.PropertyConfigurator;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EnableAutoConfiguration(exclude={HibernateJpaAutoConfiguration.class})
public class EasyshopApplication {

	public static void main(String[] args) {
		loadLogFile();
		if(args.length == 0){
    		System.out.println("Invalid Commandline argument. Please provide Consumer Properties file.");
	        System.exit(0);
	    }
		new SpringApplicationBuilder(EasyshopApplication.class)
		.properties("spring.config.name:"+args[0].replaceAll(".properties", ""))
		.build()
		.run(args);
	}
	public static void loadLogFile(){
		File log4jfile = new File("log4j-parserservice.properties");
		PropertyConfigurator.configure(log4jfile.getAbsolutePath());
	}

}


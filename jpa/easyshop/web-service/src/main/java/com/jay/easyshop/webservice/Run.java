package com.jay.easyshop.webservice;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@EnableAutoConfiguration(exclude={HibernateJpaAutoConfiguration.class})
@SpringBootApplication(scanBasePackages = "com.jay.easyshop")
public class Run {

	public static void main(String[] args) {
		//loadLogFile();
		if(args.length == 0){
    		System.out.println("Invalid Commandline argument. Please provide Consumer Properties file.");
	        System.exit(0);
	    }
		new SpringApplicationBuilder(Run.class)
		.properties("spring.config.name:"+args[0].replaceAll(".properties", ""))
		.build()
		.run(args);
	}
}

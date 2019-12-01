package com.codenotfound.kafka;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.codenotfound.kafka.consumer.Receiver;
import com.codenotfound.kafka.producer.Sender;
import com.codenotfound.kafka.producer.Sender2;

@SpringBootApplication
public class SpringKafkaApplication  implements CommandLineRunner{

	  private static final Logger LOGGER =LoggerFactory.getLogger(Receiver.class);
	 
	  @Autowired
	  private Sender sender;	
	  
	  @Autowired
	  private Sender2 sender2;
	

  public static void main( String[] args )
  {
  	SpringApplication.run(SpringKafkaApplication.class, args);
  }

@Override
public void run(String... args) throws Exception {
	 	 sender.send();
	 	//sender2.send();
	 	LOGGER.info("request completed");
	}
}

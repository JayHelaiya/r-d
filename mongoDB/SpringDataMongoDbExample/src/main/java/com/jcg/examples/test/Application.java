package com.jcg.examples.test;


import java.util.List;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.jcg.examples.entity.Address;
import com.jcg.examples.entity.User;
import com.jcg.examples.repo.AddressRepo;
import com.jcg.examples.repo.PersonRepo;


public class Application
{
		public static void main(String[] args)
		{
				ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(new ClassPathResource("spring-config.xml").getPath());
				PersonRepo personRepo = context.getBean(PersonRepo.class);
				AddressRepo addressRepo = context.getBean(AddressRepo.class);
				
				User personAchilles = new User();
				personAchilles.setPersonId(1l);
				personAchilles.setName("Achilles");
				personRepo.save(personAchilles);
				User personHektor = new User();
				personHektor.setPersonId(2l);
				personHektor.setName("Hektor");
				
				Address address = new Address(1,"221b Baker Street","London NW1","London",12345l);
				List<Address> addresses = personHektor.getAddresses();
				addresses.add(address);
				personAchilles.setAddresses(addresses);				
				
				addressRepo.save(address);
				personRepo.save(personHektor);
				
				Iterable<User> personList = personRepo.findAll();
				System.out.println("Person List : ");
				for (User person : personList)
        {
		        System.out.println(person);
        }
				
				System.out.println("Person with Id 1 is "+personRepo.searchByName("Hektor"));
				
				context.close();

		}
}

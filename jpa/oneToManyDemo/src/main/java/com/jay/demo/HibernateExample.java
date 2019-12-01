package com.jay.demo;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.jay.demo.model.Person;
import com.jay.demo.model.Phone;


public class HibernateExample {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		//test1();
		loadData();
	}
	
	// save vs persist
	
	public static void loadData() {
	
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    Person person = (Person)session.load(Person.class, 1L);
	    System.out.println(person.getId());
	    System.out.println(person.getName());
	    System.out.println(person.getPhones());
	    
	}

	public static void test1() {
			// Prep Work
			    Session session = HibernateUtil.getSessionFactory().openSession();
					
				//save example - without transaction
			    Person person = getPrepareInstance();
				session.save(person);
				session.flush(); 
				System.out.println("*****");
				session.close();
	}
	
	public static Person getPrepareInstance() {
		Person jay = new Person();
		jay.setName("jayesh helaiya");

		List<Phone> phones=new ArrayList<Phone>();
		phones.add(new Phone("redme note5 pro",jay));
		phones.add(new Phone("nokia 1209",jay));
		phones.add(new Phone("samsang 133",jay));
		
		jay.setPhones(phones);
		return jay;
	}

}

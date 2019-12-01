package com.jay.demo;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jay.demo.model.Person;

public class HibernateExample {

	public static void main(String[] args) {
		//saveData();
		mergeData();
	}
	
	public static void loadData() {
		
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    Person person = (Person)session.load(Person.class, 1L);
	    System.out.println(person.getId());
	    System.out.println(person.getName());
	    
	}
	
	public static void updateData() {
		
		  Session session = HibernateUtil.getSessionFactory().openSession();
		 
		  Person person = (Person)session.get(Person.class, 1l); // once u load from database and close session 
		  session.close();
		  person.setName("dilip1"); // modified detached object
		  
		  Session session1 = HibernateUtil.getSessionFactory().openSession();
		  Person person1 = (Person)session1.get(Person.class, 1l); // person is detached and person1 is persist  with session both has same id
		  Transaction beginTransaction = session1.beginTransaction();
		  session1.update(person);	// " org.hibernate.NonUniqueObjectException: A different object with the same identifier value was already associated with the session
		  beginTransaction.commit();
		  session1.close();
	}
	
	
	public static void mergeData() {
		
		  Session session = HibernateUtil.getSessionFactory().openSession();
		 
		  Person person = (Person)session.get(Person.class, 1l); // once u load from database and close session 
		  session.close();
		  person.setName("dilip1"); // modified detached object
		  
		  Session session1 = HibernateUtil.getSessionFactory().openSession();
		  Person person1 = (Person)session1.get(Person.class, 1l); // person is detached and person1 is persist  with session both has same id
		  Transaction beginTransaction = session1.beginTransaction();
		  session1.merge(person);		
		  beginTransaction.commit();
		  session1.close();
	}
	
	public static void saveData() {
	
		  Session session = HibernateUtil.getSessionFactory().openSession();
		  Transaction beginTransaction = session.beginTransaction();
		  session.save(new Person("jay"));	
		  beginTransaction.commit();
		  session.close();
	}
}

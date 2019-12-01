package com.javabycode.hibernate;

import org.hibernate.Session;

import com.javabycode.hibernate.model.Student;

public class HibernateExample {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		test3();
	}
	
//1)save 
	
	
	public static void test1() {
			// Prep Work
			    Session session = HibernateUtil.getSessionFactory().openSession();
					
				//save example - without transaction
				Student emp = new Student();
				emp.setId(10);
				emp.setName("mina");
				emp.setSalary(1000);
			    long id = (Long) session.save(emp);
				session.flush();
				session.close();
				System.out.println(" Identifier : " + id);
			    System.out.println("successfully saved");
	}
	
	
	//1)save 
	
	public static void test2() {
		// Prep Work
		    Session session = HibernateUtil.getSessionFactory().openSession();
				
			//save example - without transaction
			Student emp = new Student();
			emp.setId(101);
			emp.setName("ninu");
			emp.setSalary(1000);
		    session.saveOrUpdate(emp);
			session.flush();
			session.close();
		    System.out.println("successfully saved");
}

	
	public static void test3() {
		// Prep Work
		    Session session = HibernateUtil.getSessionFactory().openSession();
				
			
			//save example - without transaction
			Student emp = new Student();
			emp.setId(101);
			emp.setName("kira"); // name update
			emp.setSalary(1000);
		    session.saveOrUpdate(emp);
			session.flush();
			session.close();
		    System.out.println("successfully saved");
}


}

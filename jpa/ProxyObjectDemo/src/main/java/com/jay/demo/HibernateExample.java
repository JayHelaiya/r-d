package com.jay.demo;

import org.hibernate.Session;

import com.jay.demo.model.Address;
import com.jay.demo.model.Employee;


public class HibernateExample {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		//test1();
		loadData();
	}
	
	// save vs persist
	
	public static void loadData() {
	
	    Session session = HibernateUtil.getSessionFactory().openSession();
	    Employee emp = (Employee)session.load(Employee.class, 1L);
	   // Employee emp1 = (Employee)session.get(Employee.class, 5L);
	    System.out.println(emp);
	}

	public static void test1() {
			// Prep Work
			    Session session = HibernateUtil.getSessionFactory().openSession();
					
				//save example - without transaction
				Employee emp = getTestEmployee();
				long id = (Long) session.save(emp);
				System.out.println("1. Employee save called without transaction, id="+id);
			/*//	session.flush(); //address will not get saved without this
				emp.setName("kiya");
				long id1 = (Long) session.save(emp);*/
				session.flush();
				System.out.println("*****");
				
				//save example - with transaction
				
			/*	Session session1 = HibernateUtil.getSessionFactory().openSession();
				Transaction tx1 = session1.beginTransaction();
				Employee emp1 = getTestEmployee();
				 session1.persist(emp1);
				 session1.evict(emp1);
				 session1.persist(emp1);
				 session1.flush();
				 System.out.println("2. Employee save called with transaction, id=");
				System.out.println("3. Before committing save transaction");
				tx1.commit();
				System.out.println("4. After committing save transaction");
				System.out.println("*****");*/
				
			
				session.close();
	}
	
	public static Employee getTestEmployee() {
		Employee emp = new Employee();
		Address add = new Address();
		emp.setName("Test Emp");
		emp.setSalary(1000);
		add.setAddressLine1("Test address1");
		add.setCity("Test City");
		add.setZipcode("12121");
		add.setEmployee(emp);
		emp.setAddress(add);
		return emp;
	}

}

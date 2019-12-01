package com.javabycode.hibernate;

import org.hibernate.Session;

import com.javabycode.hibernate.model.Address;
import com.javabycode.hibernate.model.Employee;

public class HibernateExample {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		test1();
	}
	
	// save vs persist
	
	public static void test1() {
			// Prep Work
			    Session session = HibernateUtil.getSessionFactory().openSession();
					
				//save example - without transaction
				Employee emp = getTestEmployee();
				long id = (Long) session.save(emp);
				/*emp.setName("kiya");
				long id1 = (Long) session.save(emp);*/
				System.out.println("1. Employee save called without transaction, id="+id);
				session.flush(); //address will not get saved without this
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
		emp.setAddress(add);
		add.setEmployee(emp);
		return emp;
	}

}

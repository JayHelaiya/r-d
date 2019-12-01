package com.javabycode.hibernate;

import org.hibernate.Session;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import com.javabycode.hibernate.model.Project;
import com.javabycode.hibernate.model.Student;

public class HibernateExample {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {

		test2();
	}
	
	// no cascade apply 
	
	public static void test1() {
			// Prep Work
			    Session session = HibernateUtil.getSessionFactory().openSession();
					
			    Student student = new Student();
			    
		        student.setStudentName("Sarah");
		        student.setStudentAge("21");
		 
		        Project project1 = new Project("L","Spring");
		        project1.setStudent(student);
		 
		        student.getStudentProjects().add(project1);
		 
		        Project project2 = new Project("M","Spring");
		        project2.setStudent(student);
		 
		        student.getStudentProjects().add(project2);
		 
		        //  no cascade apply thats why refered entity also need to be save  
		        
		        session.save(student);
		        session.save(project1);
		        session.save(project2);
		        
		        session.flush();
		        session.close();
		        
		        System.out.println("saved successFully");
		 
	}
	
	
	//cascade apply =  @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
	
		public static void test2() {
				// Prep Work
				    Session session = HibernateUtil.getSessionFactory().openSession();
						
				    Student student = new Student();
				    
				    student.setStudentName("jay");
			        student.setStudentAge("25");
			 
			        Project project1 = new Project("L","Spring");
			        project1.setStudent(student);
			 
			        student.getStudentProjects().add(project1);
			 
			        Project project2 = new Project("M","Spring");
			        project2.setStudent(student);
			 
			        student.getStudentProjects().add(project2);
			 
			        // cascade apply thats why refered entity need not to be save  
			        
			        session.save(student);
			        
			        session.flush();
			        session.close();
			        
			        System.out.println("saved successFully");
			 
		}



}

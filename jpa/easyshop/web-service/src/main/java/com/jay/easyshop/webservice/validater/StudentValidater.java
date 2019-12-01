package com.jay.easyshop.webservice.validater;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jay.easyshop.databaseservice.model.Student;
import com.jay.easyshop.operationservices.operation.StudentOperation;

@Component
public class StudentValidater {

	@Autowired
	StudentOperation studentOperation;
	
	public  void registerValidater(Student student) {
		
		if(student!=null) {
			studentOperation.create(student);
			System.out.println(student);
		}
	}
}

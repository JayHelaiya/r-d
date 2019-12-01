package com.jay.easyshop.webservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jay.easyshop.databaseservice.model.Student;
import com.jay.easyshop.operationservices.operation.StudentOperation;
import com.jay.easyshop.webservice.response.model.CommonResponse;
import com.jay.easyshop.webservice.validater.StudentValidater;

@RestController
@RequestMapping("/student")
public class StudentController  {
	
	@Autowired
	StudentValidater studentValidater;
	
	@Autowired
	StudentOperation studentOperation;
	
	@GetMapping("{id}")
	public @ResponseBody Student get(@PathVariable Long id) {
		return studentOperation.get(id);
	}
	
	@PostMapping
	public @ResponseBody CommonResponse create(@RequestBody Student student) {
		
		System.out.println("student:"+student);
		studentValidater.registerValidater(student);
		CommonResponse response=new CommonResponse();
		response.setResponseCode("000");
		response.setDescription("new student is created");
		response.setData(student);
		return response;
	}
}

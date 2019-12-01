package com.jay.customer.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.jay.customer.model.Customer;
import com.jay.customer.service.CustomerService;
import com.jay.customer.utility.CommonResponse;
import com.jay.customer.utility.JsonUtil;

import ch.qos.logback.classic.pattern.Util;

@RestController
public class CustomerController {

	@Autowired
	CustomerService customerService;

	@RequestMapping(value = "/getAllCustomers",produces = { "application/json", "application/xml" })
	public List<Customer> getAllCustomers() {

		return  customerService.getAllCustomers();
	}

	@RequestMapping(value = "/")
	public String goToHomePage() {
		return "wellcome";
	}

	@PostMapping(value = "/addCustomer",produces = { "application/json" })
	public @ResponseBody CommonResponse addCustomer(
												@RequestBody Customer customer, 
												@RequestHeader(name = "X-COM-LOCATION", required = true) String headerLocation
			                                       ) {	
		
		
		CommonResponse response=new CommonResponse();
		response.setData(JsonUtil.toJson(customer));
		System.out.println(customer);
		return response;
	}
	
	@GetMapping(value = "/getCustomer",produces = { "application/json", "application/xml" })
	public @ResponseBody List<Customer> getCustomerList(
			@RequestHeader(name = "X-COM-LOCATION", required = true) String headerLocation) {
		
		Customer jay =new Customer();
		jay.setCustomerName("jay");
		jay.setEmail("jay@gmail.com");
		jay.setAge(25);
		
		Customer bhumi =new Customer();
		bhumi.setCustomerName("bhumi");
		bhumi.setEmail("bhumi@gmail.com");
		bhumi.setAge(17);
		
		List< Customer> customers=new ArrayList<>();
		customers.add(jay);
		customers.add(bhumi);
		
		System.out.println("headerLocation="+headerLocation);
		return customers;
	}
	
}

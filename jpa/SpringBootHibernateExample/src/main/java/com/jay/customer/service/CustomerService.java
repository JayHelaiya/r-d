package com.jay.customer.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jay.customer.dao.CustomerDao;
import com.jay.customer.model.Customer;


@Service("customerService")
public class CustomerService {

	@Autowired
	CustomerDao customerDao;

	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}


	@Transactional
	public void addCustomer(Customer customer) {
		customerDao.addCustomer(customer);
	}
	
	public Customer getCustomer(int id) {
		return customerDao.getCustomer(id);
	}
}

package com.jay.customer.dao;

import java.util.List;

import com.jay.customer.model.Customer;

public interface CustomerDao {
	public List<Customer> getAllCustomers() ;
	public Customer addCustomer(Customer customer);
	public Customer getCustomer(int id);
}

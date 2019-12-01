package com.jay.demo.model;

import java.util.List;

public class ProxyPerson extends Person{
	
	@Override
	public List<Phone> getPhones() {
		// TODO Auto-generated method stub
		return super.getPhones();
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return super.getName();
	}
	
	@Override
	public Long getId() {
		// TODO Auto-generated method stub
		return super.getId();
	}
}

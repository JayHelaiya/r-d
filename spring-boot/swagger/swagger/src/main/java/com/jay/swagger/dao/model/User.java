package com.jay.swagger.dao.model;

import java.io.Serializable;
import java.util.Date;

import org.springframework.hateoas.ResourceSupport;

public class User extends ResourceSupport implements Serializable {

	private int userId;
	private String name;
	private Date date;
	
	public User() {
	}
	
	

	public User(int userId, String name, Date date) {
		super();
		this.userId = userId;
		this.name = name;
		this.date = date;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}

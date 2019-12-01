package com.jay.demo.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "emp_id")
	private Long id;

	@Column(name = "emp_name")
	private String name;

	@Column(name = "emp_salary")
	private double salary;

	@OneToOne(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private Address address;

        //Getter setter methods
	
	
	@Override
	public String toString() {
		return "Id= " + id + ", Name= " + name + ", Salary= " + salary
				+ ", {Address= " + address + "}";
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	

}
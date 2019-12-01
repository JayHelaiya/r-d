package com.javabycode.hibernate.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "ADDRESS")
public class Address {

	@Id
	@GeneratedValue
	private long id;

	@Column(name = "address_line1")
	private String addressLine1;

	@Column(name = "zipcode")
	private String zipcode;

	@Column(name = "city")
	private String city;

	@OneToOne
	@PrimaryKeyJoinColumn
	private Employee employee;

	
	
	
        //Getter setter methods

	public long getId() {
		return id;
	}




	public void setId(long id) {
		this.id = id;
	}




	public String getAddressLine1() {
		return addressLine1;
	}




	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}




	public String getZipcode() {
		return zipcode;
	}




	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}




	public String getCity() {
		return city;
	}




	public void setCity(String city) {
		this.city = city;
	}




	public Employee getEmployee() {
		return employee;
	}




	public void setEmployee(Employee employee) {
		this.employee = employee;
	}




	@Override
	public String toString() {
		return "AddressLine1= " + addressLine1 + ", City=" + city
				+ ", Zipcode=" + zipcode;
	}
}
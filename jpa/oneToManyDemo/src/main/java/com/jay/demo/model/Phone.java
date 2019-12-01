package com.jay.demo.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Phone {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	private String name;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="OWNER_ID")
	private Person owner;
	
	public Phone() {}
	
	public Phone(String name,Person owner) {
		this.name=name;
		this.owner=owner;
		
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Person getOwner() {
		return owner;
	}

	public void setOwner(Person owner) {
		this.owner = owner;
	}

}
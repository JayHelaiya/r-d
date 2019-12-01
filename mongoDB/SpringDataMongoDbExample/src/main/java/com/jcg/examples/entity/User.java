package com.jcg.examples.entity;


import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.jcg.examples.entity.annotation.CascadeSave;

@Document
public class User {
  @Id
  private ObjectId id;
  private String name;

  @DBRef
  @CascadeSave
  private Address address;

  public User(String name) {
      this.name = name;
  }

public ObjectId getId() {
	return id;
}

public void setId(ObjectId id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public Address getAddress() {
	return address;
}

public void setAddress(Address address) {
	this.address = address;
}

}
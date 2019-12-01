package com.jcg.examples.entity;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Address {
  @Id
  private ObjectId id;
  private String city;

  public Address(String city) {
      this.city = city;
  }

public ObjectId getId() {
	return id;
}

public void setId(ObjectId id) {
	this.id = id;
}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}
}
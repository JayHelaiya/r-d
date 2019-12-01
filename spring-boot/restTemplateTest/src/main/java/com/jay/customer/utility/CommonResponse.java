package com.jay.customer.utility;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CommonResponse implements Response {

	private static final long serialVersionUID = 6306225240617386613L;

	private String data="";

	public String getData() {
		return data;
	}
	@JsonProperty(value="Data")
	public void setData(String data) {
		this.data = data;
	}

}

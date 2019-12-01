package com.jay.easyshop.webservice.response.model;

public class CommonResponse implements Response{

	private static final long serialVersionUID = 6306225240617386613L;
	
	private String responseCode;
	
	private String description;
	
	private Object data;

	public String getResponseCode() {
		return responseCode;
	}

	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

}

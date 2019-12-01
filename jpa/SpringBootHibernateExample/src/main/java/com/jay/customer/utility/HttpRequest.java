package com.jay.customer.utility;
import java.util.Map;

import org.springframework.http.HttpMethod;
import org.springframework.util.MultiValueMap;


public class HttpRequest {

	private Map<String, String> queryParamMap;
	private Map<String, String> pathParamMap;
	private String requestUrl;
	private String requestBody;
	private HttpMethod httpMethod = HttpMethod.POST;
	private MultiValueMap<String,String> headerMap;
	
	public Map<String, String> getQueryParamMap() {
		return queryParamMap;
	}
	public void setQueryParamMap(Map<String, String> queryParamMap) {
		this.queryParamMap = queryParamMap;
	}
	public Map<String, String> getPathParamMap() {
		return pathParamMap;
	}
	public void setPathParamMap(Map<String, String> pathParamMap) {
		this.pathParamMap = pathParamMap;
	}
	public String getRequestUrl() {
		return requestUrl;
	}
	public void setRequestUrl(String requestUrl) {
		this.requestUrl = requestUrl;
	}

	public String getRequestBody() {
		return requestBody;
	}
	public void setRequestBody(String requestBody) {
		this.requestBody = requestBody;
	}
	public MultiValueMap<String, String> getHeaderMap() {
		return headerMap;
	}
	public void setHeaderMap(MultiValueMap<String, String> headerMap) {
		this.headerMap = headerMap;
	}
	public HttpMethod getHttpMethod() {
		return httpMethod;
	}
	public void setHttpMethod(HttpMethod httpMethod) {
		this.httpMethod = httpMethod;
	}
	
}

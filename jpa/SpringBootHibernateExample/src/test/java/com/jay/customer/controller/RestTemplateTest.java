package com.jay.customer.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.net.URI;
import java.net.URISyntaxException;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import com.jay.customer.model.Customer;
import com.jay.customer.utility.CommonResponse;
import com.jay.customer.utility.Constant;
import com.jay.customer.utility.HttpConnector;
import com.jay.customer.utility.HttpRequest;
import com.jay.customer.utility.JsonUtil;;

/**
 * @author bytesTree
 * @see <a href="http://www.bytestree.com/">BytesTree</a>
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class RestTemplateTest {

	 @LocalServerPort
	 int randomServerPort;
	    
	    /**
	     * 
	     *  get method with "getForEntity"
	     * @throws URISyntaxException
	     */
	    @Test
	    public void testWelcomeSuccess() throws URISyntaxException
	    {
	        RestTemplate restTemplate = new RestTemplate();
	        final String baseUrl = "http://localhost:" + randomServerPort + "/";
	        URI uri = new URI(baseUrl);
	        ResponseEntity<String> result = restTemplate.getForEntity(uri, String.class);
	        System.out.println(result);
	        //Verify request succeed	
	        assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue(), "Incorrect Response Status");
	    } 
	    
	    /**
	     * GET method 
	     * 
	     *  Note: RestTemplate getForEntity() method does not support request headers. Please use exchange() method if headers are necessary.
	     * @throws URISyntaxException
	     */
	    @Test
	    public void testGetCustomerListSuccessWithHeaders() throws URISyntaxException
	    {
	        RestTemplate restTemplate = new RestTemplate();
	         
	        final String baseUrl = "http://localhost:"+randomServerPort+"/getCustomer";
	        URI uri = new URI(baseUrl);
	         
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("X-COM-LOCATION", "USA");
	     
	        HttpEntity<Customer> requestEntity = new HttpEntity<>(null, headers);
	     
	        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.GET, requestEntity, String.class);
	        assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue(), "Incorrect Response Status");
	    }
	    
	    @Test
	    public void testPostCustomerWithHeaders() throws URISyntaxException
	    {
	        RestTemplate restTemplate = new RestTemplate();
	         
	        final String baseUrl = "http://localhost:"+randomServerPort+"/addCustomer";
	        URI uri = new URI(baseUrl);
	         
	        HttpHeaders headers = new HttpHeaders();
	        headers.set("Content-Type", "application/json");
	        headers.set("X-COM-LOCATION", "USA");
	     
	        
	        Customer customer=new Customer();
	        customer.setId(21);
	        customer.setCustomerName("jayesh");
	        customer.setEmail("jay@gmail.com");
	        customer.setAge(21);
	        
	        HttpEntity<Customer> requestEntity = new HttpEntity<>(customer, headers);
	     
	        ResponseEntity<String> result = restTemplate.exchange(uri, HttpMethod.POST, requestEntity, String.class);
	        assertEquals(HttpStatus.OK.value(), result.getStatusCodeValue(), "Incorrect Response Status");
	    }
	    
	    @Test
	    public void testRestTemplete() {
	    	
	    	Customer customer=new Customer();
	    	customer.setId(21);
	    	customer.setCustomerName("jay");
	    	customer.setEmail("jay@gmail.com");
	    	customer.setAge(26);
	    	
	    	HttpConnector httpConnector =new HttpConnector();
	    	final String baseUrl = "http://localhost:"+randomServerPort+"/addCustomer";
	    	HttpRequest httpRequest = new HttpRequest();
			
			MultiValueMap<String, String> headerMap = new LinkedMultiValueMap<String, String>(); 
			headerMap.add("Content-Type", "application/json");
			headerMap.add("X-COM-LOCATION", "USA");
			
			httpRequest.setRequestUrl(baseUrl);
			httpRequest.setHttpMethod(HttpMethod.POST);
			httpRequest.setRequestBody(JsonUtil.toJson(customer));
			httpRequest.setHeaderMap(headerMap);
			ResponseEntity<CommonResponse> responseEntity = httpConnector.httpRequest(httpRequest, Constant.FORMDATA);
			System.out.println(responseEntity.getBody().getData()); 
	    }
	    
}

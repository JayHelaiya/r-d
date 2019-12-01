package com.jay.customer.controller;

import java.util.HashMap;
import java.util.Map;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.util.UriComponentsBuilder;;

/**
 * @author bytesTree
 * @see <a href="http://www.bytestree.com/">BytesTree</a>
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class RestTemplateGenericTest {

		@LocalServerPort
	 	int randomServerPort;
		
		/**  
		 * get detail of URL
		 * 
		 */
		@Test
		public void getQueryParameterToURLTest() {
			String URL="http://localhost:8080/api/v1/transactions?pageNumber=1&walletId=2323JK&pageSize=10";
			UriComponentsBuilder urlBuilder = UriComponentsBuilder.fromUriString(URL);
			System.out.println(urlBuilder);
		}
		
		@Test
		public void urlsetURLDetailTest() {
			
			UriComponentsBuilder urlBuilder = UriComponentsBuilder.newInstance();
			urlBuilder.scheme("http");
			urlBuilder.host("www.google.com");
			urlBuilder.port("8080");
			urlBuilder.path("article-name");
			System.out.println(urlBuilder.buildAndExpand().toUri());
		}

		@Test
		public void urlParameterANDQueryParameterTest() {

				String url = "http://test.com/solarSystem/planets/{planet}/moons/{moon}";
				
				Map<String, String> uriParams = new HashMap<>(); // URI (URL) parameters
				uriParams.put("planet", "Mars");
				uriParams.put("moon", "Phobos");
				
				MultiValueMap<String, String> queryParams = new LinkedMultiValueMap<>();    //  query parameter
				queryParams.add("firstName", "Mark");
				queryParams.add("lastName", "Watney");
				
				UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(url);
				builder.queryParams(queryParams);
				
				System.out.println(builder.buildAndExpand(uriParams).toUri());
		}
		
		public static void main(String[] args) {
			
			// creating and initializing two dimensional array with shortcut syntax
			int[][] arrInt = { { 1, 2, 3 }, { 4, 5, 6 } };
			for (int i = 0; i < arrInt.length; i++) {
				for (int j = 0; j < arrInt[i].length; j++) {
					System.out.print(arrInt[i][j] + " ");
				}
				System.out.println("");
			}
			
			String value="jayesh";
			
			char[] charArray = value.toCharArray();
			System.out.println(charArray);
			value.substring(0, 2);
			
		}
		
}

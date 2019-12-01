package com.jay.customer.utility;
import java.net.URI;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;


@Component
public class HttpConnector {
	
	private static RestTemplate restTemplate = new RestTemplate();

	public static void setTimeOut(int urlConnectionTimeout, int urlReadTimeout) {
		HttpComponentsClientHttpRequestFactory httpComponentsClientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		httpComponentsClientHttpRequestFactory.setReadTimeout(urlReadTimeout);
		httpComponentsClientHttpRequestFactory.setConnectTimeout(urlConnectionTimeout);
		restTemplate.setRequestFactory(httpComponentsClientHttpRequestFactory);
	}

	/**
	 * This method is used for serving all http request
	 * 
	 * @param httpRequest
	 * @param requestType
	 * @param httpMethod
	 * @return
	 * @throws MobifinX1Exception
	 */

	public ResponseEntity<CommonResponse> httpRequest(HttpRequest httpRequest, String requestType) {
		HttpEntity<?> entity = null;
		URI uri = null;
		try {
			System.out.println("RequestUrl : " + httpRequest.getRequestUrl());
			UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(httpRequest.getRequestUrl());
			if (!CollectionUtils.isEmpty(httpRequest.getQueryParamMap())) {
				System.out.println("Request Query Param :" + httpRequest.getQueryParamMap());
				httpRequest.getQueryParamMap().forEach((key, value) -> builder.queryParam(key, value));
			}
			if (!CollectionUtils.isEmpty(httpRequest.getPathParamMap())) {
				System.out.println("Request Path Param : " + httpRequest.getPathParamMap());
				uri = builder.buildAndExpand(httpRequest.getPathParamMap()).toUri();
			} else {
				uri = builder.build().toUri();
			}
			if (!CollectionUtils.isEmpty(httpRequest.getHeaderMap())) {
				System.out.println("Header Data: " + httpRequest.getHeaderMap());
			}

			if (!StringUtils.isEmpty(httpRequest.getRequestBody())) {
					entity = new HttpEntity<>(httpRequest.getRequestBody(), httpRequest.getHeaderMap());
			} else {
				    entity = new HttpEntity<>(httpRequest.getHeaderMap());
			}
			return restTemplate.exchange(uri, httpRequest.getHttpMethod(), entity, CommonResponse.class);
		} catch (ResourceAccessException e) {
			System.out.println(e);
		} catch (HttpClientErrorException e) {
			System.out.println(e);
			if (!StringUtils.isEmpty(e.getResponseBodyAsString()) && e.getStatusCode() != HttpStatus.NOT_FOUND) {
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		return null;
	}
}

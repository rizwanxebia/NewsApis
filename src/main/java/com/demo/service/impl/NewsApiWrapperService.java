package com.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.demo.exception.ServiceException;
import com.demo.model.ResponseObject;

@Component
public class NewsApiWrapperService {

	@Autowired
	private RestTemplate restTemplate;

	public ResponseObject getResponse(String query) {
		String refineUrl = "http://newsapi.org/v2/everything";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(refineUrl).queryParam("q", query)
				.queryParam("from", "2020-03-10").queryParam("sortBy", "publishedAt")
				.queryParam("apiKey", "9f96caf0e5b743b9886b31dba4446283");

		HttpEntity<?> entity = new HttpEntity<>(headers);

		ResponseEntity<ResponseObject> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
				ResponseObject.class);
		
		if(response.getStatusCode() != HttpStatus.OK) {
			throw new ServiceException("");
		}
		return response.getBody();

	}
	public ResponseObject getResponseSelectedParameter(String parameter ) {
		String refineUrl = "https://newsapi.org/v2/top-headlines";
		HttpHeaders headers = new HttpHeaders();
		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);

		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(refineUrl).queryParam("country", "us")
				.queryParam("category", parameter)
				.queryParam("apiKey", "9f96caf0e5b743b9886b31dba4446283");

		HttpEntity<?> entity = new HttpEntity<>(headers);

		ResponseEntity<ResponseObject> response = restTemplate.exchange(builder.toUriString(), HttpMethod.GET, entity,
				ResponseObject.class);
		
		if(response.getStatusCode() != HttpStatus.OK) {
			throw new ServiceException("");
		}
		return response.getBody();

	}
	
}

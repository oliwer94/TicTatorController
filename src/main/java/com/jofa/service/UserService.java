package com.jofa.service;

import java.io.IOException;
import java.nio.file.attribute.UserPrincipalNotFoundException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.jofa.simpleuser.SimpleUser;

public class UserService {

	public UserService() {
	}

	@SuppressWarnings("rawtypes")
	public ResponseEntity PostJson(HttpEntity entity, String URL, Class<?> classType) throws IOException, HttpClientErrorException
	{
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForEntity(URL, entity, classType);
	}
	
	public SimpleUser GetJson(String URL,int id)
	{
		RestTemplate restTemplate = new RestTemplate();		
		
		return (SimpleUser) restTemplate.getForObject(URL + id, SimpleUser.class);
	}
	
	@SuppressWarnings("unchecked")
	public SimpleUser logInUser(SimpleUser simpleUser, String URL) throws IOException
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<SimpleUser> entity = new HttpEntity<SimpleUser>(simpleUser, headers);
		ResponseEntity<SimpleUser> response = PostJson(entity, URL, simpleUser.getClass());
		
		return response == null ? null : (SimpleUser)response.getBody();
	}
	
	@SuppressWarnings("rawtypes")
	public  void registerUser(HttpServletRequest request, SimpleUser simpleUser, String URL) throws IOException
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<SimpleUser> entity = new HttpEntity<SimpleUser>(simpleUser, headers);
		ResponseEntity response = PostJson(entity, URL, simpleUser.getClass());	
		
		if (response.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
			throw new UserPrincipalNotFoundException(simpleUser.getUsername());
		}
	}
	
//	public  void addToOnlineList(HttpServletRequest request, SimpleUser simpleJack, String URL) throws IOException
//	{
//		simpleJack = PostJson(request, simpleJack, URL);		
//	}
	
	

}

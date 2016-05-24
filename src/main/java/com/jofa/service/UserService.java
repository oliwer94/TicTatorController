package com.jofa.service;

import java.io.IOException;
import java.nio.file.attribute.UserPrincipalNotFoundException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.jofa.simpleuser.SimpleUser;

public class UserService {

	public UserService() {
	}

	@SuppressWarnings("rawtypes")
	public ResponseEntity PostJson(HttpEntity entity, String URL) throws IOException 
	{
		RestTemplate restTemplate = new RestTemplate();
		ResponseEntity response = restTemplate.postForEntity(URL, entity, SimpleUser.class);
		
		return response;
	}
	
	public SimpleUser GetJson(String URL,int id)
	{
		RestTemplate restTemplate = new RestTemplate();		
		
		return (SimpleUser) restTemplate.getForObject(URL + id, SimpleUser.class);
	}
	
	@SuppressWarnings("unchecked")
	public SimpleUser logInUser(SimpleUser simpleJack, String URL) throws IOException
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<SimpleUser> entity = new HttpEntity<SimpleUser>(simpleJack, headers);
		ResponseEntity<SimpleUser> response = PostJson(entity, URL);
		if (response.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
			throw new UserPrincipalNotFoundException(simpleJack.getUsername());
		}
		
		return (SimpleUser)response.getBody();
	}
	
	@SuppressWarnings("rawtypes")
	public  void registerUser(HttpServletRequest request, SimpleUser simpleJack, String URL) throws IOException
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<SimpleUser> entity = new HttpEntity<SimpleUser>(simpleJack, headers);
		ResponseEntity response = PostJson(entity, URL);	
		
		if (response.getStatusCode().equals(HttpStatus.NOT_FOUND)) {
			throw new UserPrincipalNotFoundException(simpleJack.getUsername());
		}
	}
	
//	public  void addToOnlineList(HttpServletRequest request, SimpleUser simpleJack, String URL) throws IOException
//	{
//		simpleJack = PostJson(request, simpleJack, URL);		
//	}
	
	

}

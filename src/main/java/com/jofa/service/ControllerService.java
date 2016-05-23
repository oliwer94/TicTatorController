package com.jofa.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.jofa.simpleuser.SimpleUser;

public class ControllerService {

	public ControllerService() {
	}

	public SimpleUser PostJsonSimpleUser(HttpServletRequest request, SimpleUser simpleJack, String URL) throws IOException 
	{
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);

		HttpEntity<SimpleUser> entity = new HttpEntity<SimpleUser>(simpleJack, headers);

		SimpleUser returnedUser = (SimpleUser) restTemplate.postForObject(URL, entity, SimpleUser.class);
		
		return returnedUser;
	}
	
	public SimpleUser GetJsonSimpleUser(String URL,int id)
	{
		RestTemplate restTemplate = new RestTemplate();		
		
		return (SimpleUser) restTemplate.getForObject(URL + id, SimpleUser.class);
	}
	
	public SimpleUser logInUser(HttpServletRequest request, SimpleUser simpleJack, String URL) throws IOException
	{
		simpleJack = PostJsonSimpleUser(request, simpleJack, URL);		
		
		request.getSession(true).setAttribute("Admin", simpleJack.getAdmin());
		
		return simpleJack;
	}
	
	public  void registerUser(HttpServletRequest request, SimpleUser simpleJack, String URL) throws IOException
	{
		simpleJack = PostJsonSimpleUser(request, simpleJack, URL);		
	}
	
	public  void addToOnlineList(HttpServletRequest request, SimpleUser simpleJack, String URL) throws IOException
	{
		simpleJack = PostJsonSimpleUser(request, simpleJack, URL);		
	}
	
	

}

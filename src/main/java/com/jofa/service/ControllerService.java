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

		return (SimpleUser) restTemplate.postForObject(URL, entity, SimpleUser.class);		
	}
	
	public SimpleUser GetJsonSimpleUser(String URL,int id)
	{
		RestTemplate restTemplate = new RestTemplate();		
		
		return (SimpleUser) restTemplate.getForObject(URL + id, SimpleUser.class);
	}
	
	public SimpleUser logInUser(HttpServletRequest request, SimpleUser simpleJack, String URL) throws IOException
	{
		simpleJack = PostJsonSimpleUser(request, simpleJack, URL);		
		
		request.getSession().setAttribute("user", simpleJack);
		
		return simpleJack;
	}	
	
	public void postVoidMethod(HttpServletRequest request, SimpleUser simpleJack, String URL) throws IOException
	{
		PostJsonSimpleUser(request, simpleJack, URL);		
	}

}

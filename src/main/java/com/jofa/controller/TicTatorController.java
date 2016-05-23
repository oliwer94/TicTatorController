package com.jofa.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import com.jofa.simpleuser.SimpleUser;

@Scope("session")
@Controller
@RequestMapping("/")
public class TicTatorController 
{
	
	private static final String VIEW_INDEX = "index";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(TicTatorController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String welcomeW(Model model) 
	{
		model.addAttribute("simpleUser", new SimpleUser());

		return VIEW_INDEX;
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public void welcome()
	{
		RestTemplate restTemplate = new RestTemplate();
		System.out.println("SENDING IT: ");
		SimpleUser obj = restTemplate.getForObject("http://192.168.220.128:8080/TicTatorUser/user/1", SimpleUser.class);
		System.out.println(obj.getUsername());
	}

	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, SimpleUser simpleJack) throws IOException
	{
		System.out.println("SENDING IT: USERNAME: "+ simpleJack.getUsername() + " PASSWORD: "+ simpleJack.getPassword());
			
		RestTemplate restTemplate = new RestTemplate();					
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);		
			
		HttpEntity<SimpleUser> entity = new HttpEntity<SimpleUser>(simpleJack, headers); 

		SimpleUser returnedUser = restTemplate.postForObject("http://192.168.220.128:8080/TicTatorUser/user/login",entity, SimpleUser.class);

	    System.out.println(returnedUser.getAdmin());
	    
	    request.getSession().setAttribute("Admin",returnedUser.getAdmin());
	
	    java.util.Enumeration<String> reqEnum = request.getAttributeNames();
		while (reqEnum.hasMoreElements()) {
			String s = reqEnum.nextElement();
			System.out.print("DUCK ME"+s);
			System.out.println("==" + request.getAttribute(s));
		}
	    return VIEW_INDEX;
	}
}
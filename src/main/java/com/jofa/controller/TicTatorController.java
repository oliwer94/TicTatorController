package com.jofa.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.ResourceAccessException;

import com.jofa.model.User;
import com.jofa.registration.RegistrationBean;
import com.jofa.service.UserService;
import com.jofa.service.loginservice.LoginService;
import com.jofa.simpleuser.SimpleUser;
import com.jofa.utils.Constants;
import com.jofa.utils.Views;

@Scope("session")
@Controller
@SessionAttributes
@RequestMapping("/")
public class TicTatorController {
	
	private final String matchMakingServiceURL = "http://192.168.220.128:8080/TicTatorMatchMaking/";
	
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(TicTatorController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, User user, Model model) throws IOException {
		System.out.println("WE ARE IN 2");
		model.addAttribute("currentUser", new User());
		return Views.LOGIN_PAGE;
	}
	
//	@RequestMapping(value = "/register", method = RequestMethod.POST)
//	public String register(HttpServletRequest request, SimpleUser simpleJack) throws IOException 
//	{
//		System.out.println("WE ARE IN 4");
//		UserService.registerUser(request, simpleJack);
//
//		return Views.VIEW_INDEX;
//	}	
	
//	@RequestMapping(value = "/logout", method = RequestMethod.GET)
//	public String logout(HttpServletRequest request, User user) throws IOException 
//	{
//		System.out.println("WE ARE IN 5");
//		//controllerService.removeFromOnlineList(request, loggedInUser, matchMakingServiceURL+"AddToOnlineUserList");
//		request.getSession(true).removeAttribute("currentUser");
//		return VIEW_INDEX;
//	}
	
	@RequestMapping(value = "/user/index", method = RequestMethod.GET)
	public String FAIL(HttpServletRequest request) throws IOException 
	{
		System.out.println("WE ARE IN 6");
		return Views.INDEX_PAGE;
	}

}
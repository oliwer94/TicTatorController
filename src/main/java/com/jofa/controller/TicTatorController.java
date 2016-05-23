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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;

import com.jofa.service.ControllerService;
import com.jofa.simpleuser.SimpleUser;

@Scope("session")
@Controller
@SessionAttributes
@RequestMapping("/")
public class TicTatorController {
	private static ControllerService controllerService = new ControllerService();
	private static final String VIEW_INDEX = "index";

	private final String userServiceURL = "http://192.168.220.128:8080/TicTatorUser/user/";
	private final String matchMakingServiceURL = "http://192.168.220.128:8080/TicTatorMatchMaking/";

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(TicTatorController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String welcomeW(Model model) {
		model.addAttribute("simpleUser", new SimpleUser());

		return VIEW_INDEX;
	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public void welcome(int id) {
		controllerService.GetJsonSimpleUser(userServiceURL, id);
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, SimpleUser simpleJack) throws IOException {
		
		SimpleUser loggedInUser = controllerService.logInUser(request, simpleJack, userServiceURL + "login");

		if(loggedInUser != null)
		{
			//controllerService.addToOnlineList(request, loggedInUser, matchMakingServiceURL+"AddToOnlineUserList");
		}
		
		return VIEW_INDEX;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request, SimpleUser simpleJack) throws IOException 
	{
		controllerService.registerUser(request, simpleJack, userServiceURL + "registerUser");

		return VIEW_INDEX;
	}	

}
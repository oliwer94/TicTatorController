package com.jofa.controller;

import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.jofa.auth.Authenticator;
import com.jofa.registration.RegistrationBean;
import com.jofa.service.UserService;
import com.jofa.simpleuser.SimpleUser;

@Scope("session")
@Controller
@SessionAttributes
@RequestMapping("/")
public class TicTatorController {
	private static UserService userService = new UserService();
	private static final String VIEW_INDEX = "index";
	private static final String SERVICE_UNAVAILABLE = "503";
	private static final String BAD_REQUEST = "400";

	private final String userServiceURL = "http://192.168.71.128:8080/TicTatorUser/user/";
	private final String matchMakingServiceURL = "http://192.168.220.128:8080/TicTatorMatchMaking/";

	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(TicTatorController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String index(Model model) {
		model.addAttribute("simpleUser", new SimpleUser());
		model.addAttribute("registrationBean", new RegistrationBean());

		return VIEW_INDEX;
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request, SimpleUser simpleJack, Model model) throws IOException {
		try {
			SimpleUser loggedInUser = userService.logInUser(simpleJack, userServiceURL + "login");
			//controllerService.addToOnlineList(request, loggedInUser, matchMakingServiceURL+"AddToOnlineUserList");
			if(loggedInUser != null)
			{
				request.getSession(true).setAttribute("user", simpleJack);
				return VIEW_INDEX;
			} else {
				model.addAttribute("loginFail", simpleJack);
				index(model);
			}
		} catch (ResourceAccessException e) {
			logger.error(e.getMessage());
			return SERVICE_UNAVAILABLE;
		}
		return VIEW_INDEX;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request, SimpleUser simpleJack) throws IOException 
	{
		userService.registerUser(request, simpleJack, userServiceURL + "registerUser");

		return VIEW_INDEX;
	}	

}
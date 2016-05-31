package com.jofa.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.servlet.http.HttpServletRequest;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.jofa.model.GameObject;
import com.jofa.model.User;
import com.jofa.service.MatchMakingService;
import com.jofa.service.UserService;
import com.jofa.utils.PropertiesUtil;
import com.jofa.utils.Views;

@Scope("session")
@Controller
@SessionAttributes
@RequestMapping("/")
public class TicTatorController
{
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(TicTatorController.class);

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(HttpServletRequest request, User user, Model model) throws IOException
	{
		model.addAttribute("currentUser", new User());
		model.addAttribute("registerUser", new User("email", "password", "username"));
		return Views.LOGIN_PAGE;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public String register(HttpServletRequest request, User user) throws IOException
	{
		String view = Views.REGISTER_SUCCESS;
		if (UserService.registerUser(request, user) != true)
		{
			return Views.REGISTER_FAIL;
		}
		if(MatchMakingService.register(user) != true) {
			return Views.REGISTER_FAIL;
		}
		return view;
	}
	
	@RequestMapping(value = "/user/play", method = RequestMethod.GET)
	public String userPlay(HttpServletRequest request) throws IOException
	{
		User user = (User) request.getSession().getAttribute("currentUser");
		MatchMakingService.stateLFG(user);
		return Views.USER_PLAY;
	}

	@RequestMapping(value = "/user/index", method = RequestMethod.GET)
	public String userIndex(HttpServletRequest request) throws IOException
	{
		return Views.USER_INDEX;
	}
	
	@RequestMapping(value = "/user/getGame", method = RequestMethod.GET)
	public ResponseEntity<GameObject> getGame(HttpServletRequest request) throws IOException
	{
		User user = (User) request.getSession().getAttribute("currentUser");
		ResponseEntity<GameObject> game = MatchMakingService.getGame(user);
		if(game != null) {
			System.out.println("gameID: " + game.getBody().getGameID() + " gameIP: " + game.getBody().getIP());
			return game;
		} else {
			return null;
		}
	}

	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public String fourOThree(HttpServletRequest request) throws IOException
	{
		return Views.PAGE_UNREACHABLE;
	}

}
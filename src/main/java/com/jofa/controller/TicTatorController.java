package com.jofa.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jofa.simpleuser.SimpleUser;

@Controller
@RequestMapping("/")
public class TicTatorController {

	private static int counter = 0;
	private static final String VIEW_INDEX = "index";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(TicTatorController.class);

	@RequestMapping(method = RequestMethod.GET)
	public String welcome(Model model) {
		model.addAttribute("simpleUser", new SimpleUser());
	      return VIEW_INDEX;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(SimpleUser simpleJack) {

		System.out.println(simpleJack.getUsername());
		return VIEW_INDEX;

	}

}
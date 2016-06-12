package com.jofa.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import com.jofa.controller.TicTatorController;

public class LogoutService implements LogoutSuccessHandler 
{
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(LogoutService.class);
	
	@Override
	public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException
	{
		logger.info("logging out " + authentication.getName());
		MatchMakingService.logOut(authentication.getName());
		response.sendRedirect("login");
	}

}

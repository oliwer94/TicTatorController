package com.jofa.service.loginservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.jofa.model.User;
import com.jofa.service.UserService;
import com.jofa.utils.Constants;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
	
	public LoginSuccessHandler() {
	}

	protected static final String URL = "http://192.168.71.128:8080/TicTatorUser";


	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		System.out.println("trying to set user to session");
		User user = UserService.findByUsername(authentication.getName());
		request.getSession().setAttribute(Constants.CURRENT_USER, user);
		response.sendRedirect("user/index");
	}
}

package com.jofa.service.loginservice;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.jofa.model.User;
import com.jofa.service.MatchMakingService;
import com.jofa.service.UserService;
import com.jofa.utils.Constants;
import com.jofa.utils.LoginAttemptFactory;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
	
	public LoginSuccessHandler() {
	}

	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
		User user = UserService.findByUsername(authentication.getName());
		UserService.saveLoginAttempt(LoginAttemptFactory.createSuccessLoginAttemptFromRequest(request));
		MatchMakingService.stateOnline(authentication.getName());
		request.getSession().setAttribute(Constants.CURRENT_USER, user);
		response.sendRedirect("user/index");
	}
}

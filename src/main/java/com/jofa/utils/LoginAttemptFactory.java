package com.jofa.utils;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.jofa.model.LoginAttempt;
import com.jofa.model.User;

public class LoginAttemptFactory
{

	public static LoginAttempt createFailedLoginAttemptFromRequest(HttpServletRequest request) {
		return new LoginAttempt(request.getParameter("username"), request.getHeader("User-Agent"), false, request.getRemoteAddr(), new Date());
	}
	
	public static LoginAttempt createSuccessLoginAttemptFromRequest(HttpServletRequest request) {
		return new LoginAttempt(request.getParameter("username"), request.getHeader("User-Agent"), true, request.getRemoteAddr(), new Date());
	}
}

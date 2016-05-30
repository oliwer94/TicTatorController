package com.jofa.utils;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import com.jofa.model.LoginAttempt;
import com.jofa.model.User;

public class LoginAttemptFactory
{

	public static LoginAttempt createLoginAttemptFromRequest(HttpServletRequest request, User user) {
		return new LoginAttempt(user.getUsername(), request.getHeader("User-Agent"), false, request.getRemoteAddr(), new Date());
	}
}

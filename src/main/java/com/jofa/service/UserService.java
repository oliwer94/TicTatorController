package com.jofa.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.jofa.model.LoginAttempt;
import com.jofa.model.User;
import com.jofa.utils.Constants;
import com.jofa.utils.PropertiesUtil;

public class UserService
{
	private static String URL = PropertiesUtil.getInstance().getValue(Constants.U_SERVICE_URL_PROP);

	@SuppressWarnings("rawtypes")
	private static ResponseEntity PostJson(HttpEntity entity, String URL, Class<?> classType)
			throws IOException, HttpClientErrorException
	{
		RestTemplate restTemplate = new RestTemplate();
		System.out.println(URL);
		return restTemplate.postForEntity(URL, entity, classType);
	}

	@SuppressWarnings("rawtypes")
	private static ResponseEntity getJson(String URL, Class<?> classType, String... args)
	{
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForEntity(URL, classType, args[0]);
	}

	@SuppressWarnings("unchecked")
	public static User authorizeUser(User user) throws IOException
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<User> entity = new HttpEntity<User>(user, headers);
		ResponseEntity<User> response = PostJson(entity, URL + Constants.U_SERVICE_AUTHORIZE,
				user.getClass());
		return (User) response.getBody();
	}

	@SuppressWarnings("unchecked")
	public static User findByUsername(String username) throws IOException
	{
		ResponseEntity<User> response = getJson(URL + Constants.U_SERVICE_FINDBYUSERNAME,
				User.class, username);
		User user = (User) response.getBody();
		if(user.getUsername()!=null) {
		} else {
			System.out.println("returned user is empty");
		}
		return user;
	}

	@SuppressWarnings({ "unchecked" })
	public static boolean registerUser(HttpServletRequest request, User user) throws IOException
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<User> entity = new HttpEntity<User>(user, headers);
		ResponseEntity<User> response = PostJson(entity, URL+ Constants.U_SERVICE_REGISTER, User.class);
		if (response.getStatusCode().equals(HttpStatus.OK))
		{
			return true;
		} else {
			return false;
		}
	}

	public static void saveLoginAttempt(LoginAttempt loginAttempt) throws IOException
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<LoginAttempt> entity = new HttpEntity<LoginAttempt>(loginAttempt, headers);
		PostJson(entity, URL + Constants.U_SERVICE_LOGINATTEMPT, loginAttempt.getClass());
	}

}

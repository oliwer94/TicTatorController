package com.jofa.service;

import java.io.IOException;
import java.nio.file.attribute.UserPrincipalNotFoundException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.jofa.model.LoginAttempt;
import com.jofa.model.User;
import com.jofa.simpleuser.SimpleUser;
import com.jofa.utils.Constants;
import com.jofa.utils.LoginAttemptFactory;

public class UserService
{

	private final static String userServiceURL = "http://192.168.71.128:8080/TicTatorUser/";

	@SuppressWarnings("rawtypes")
	private static ResponseEntity PostJson(HttpEntity entity, String URL, Class<?> classType)
			throws IOException, HttpClientErrorException
	{
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForEntity(URL, entity, classType);
	}

	@SuppressWarnings("rawtypes")
	private static ResponseEntity getJson(String URL, Class<?> classType, String... args)
	{
		System.out.println("We about to do this");
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForEntity(URL, classType, args[0]);
	}

	@SuppressWarnings("unchecked")
	public static User authorizeUser(User user) throws IOException
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<User> entity = new HttpEntity<User>(user, headers);
		System.out.println(entity.getBody().getUsername() + entity.getBody().getPassword());
		ResponseEntity<User> response = PostJson(entity, userServiceURL + Constants.USER_SERVICE_AUTHORIZE,
				user.getClass());
		return (User) response.getBody();
	}

	@SuppressWarnings("unchecked")
	public static User findByUsername(String username) throws IOException
	{
		ResponseEntity<User> response = getJson(userServiceURL + Constants.USER_SERVICE_FINDBYUSERNAME,
				User.class, username);
		System.out.println("we did it");
		User user = (User) response.getBody();
		if(user.getUsername()!=null) {
			System.out.println("returned user har username: " + user.getUsername());
		} else {
			System.out.println("returned user is empty");
		}
		return user;
	}

	@SuppressWarnings("rawtypes")
	public static void registerUser(HttpServletRequest request, SimpleUser simpleUser) throws IOException
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<SimpleUser> entity = new HttpEntity<SimpleUser>(simpleUser, headers);
		ResponseEntity response = PostJson(entity, userServiceURL, simpleUser.getClass());

		if (response.getStatusCode().equals(HttpStatus.NOT_FOUND))
		{
			throw new UserPrincipalNotFoundException(simpleUser.getUsername());
		}
	}

	public static void saveLoginAttempt(HttpServletRequest request, User user) throws IOException
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		LoginAttempt loginAttempt = LoginAttemptFactory.createLoginAttemptFromRequest(request, user);
		HttpEntity<LoginAttempt> entity = new HttpEntity<LoginAttempt>(loginAttempt, headers);
		PostJson(entity, userServiceURL + Constants.USER_SERVICE_LOGINATTEMPT, loginAttempt.getClass());
	}

	// public void addToOnlineList(HttpServletRequest request, SimpleUser
	// simpleJack, String URL) throws IOException
	// {
	// simpleJack = PostJson(request, simpleJack, URL);
	// }

}

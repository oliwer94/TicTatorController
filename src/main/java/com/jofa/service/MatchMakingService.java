package com.jofa.service;

import java.io.IOException;
import java.util.Properties;

import javax.annotation.Resource;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.ResourceAccessException;
import org.springframework.web.client.RestTemplate;

import com.jofa.model.GameObject;
import com.jofa.model.User;
import com.jofa.utils.Constants;
import com.jofa.utils.PropertiesUtil;

public class MatchMakingService
{
	private final static String URL = PropertiesUtil.getInstance().getValue(Constants.MM_SERVICE_URL_PROP);

	@SuppressWarnings("rawtypes")
	private static ResponseEntity PostJson(HttpEntity entity, String URL, Class<?> classType, String... args)
			throws IOException, HttpClientErrorException
	{
		RestTemplate restTemplate = new RestTemplate();
		try
		{
			return restTemplate.postForEntity(URL, entity, classType, args[0]);
		} catch (HttpServerErrorException e)
		{
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		} catch (ResourceAccessException e)
		{
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}

	@SuppressWarnings({ "rawtypes" })
	private static ResponseEntity getJson(String URL, Class<?> classType, String... args)
	{
		RestTemplate restTemplate = new RestTemplate();
		try
		{
			return restTemplate.getForEntity(URL, classType, args[0]);
		} catch (HttpClientErrorException e)
		{
			return new ResponseEntity(HttpStatus.BAD_REQUEST);
		}
	}

	public static void logOut(String username) throws IOException
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(username, headers);
		PostJson(entity, URL + Constants.MM_SERVICE_LOGOUT, String.class, username);
	}

	@SuppressWarnings("rawtypes")
	public static boolean register(User user) throws IOException
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<User> entity = new HttpEntity<User>(user, headers);
		ResponseEntity response = PostJson(entity, URL + Constants.MM_SERVICE_REGISTER, User.class, user.getUsername());

		if (response.getStatusCode().equals(HttpStatus.OK))
		{
			return true;
		} else
		{
			return false;
		}
	}

	public static void stateOnline(String username) throws IOException
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(username, headers);
		PostJson(entity, URL + Constants.MM_SERVICE_STATE_ONLINE, User.class, username);
	}

	public static void stateLFG(User user) throws IOException
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<User> entity = new HttpEntity<User>(user, headers);
		PostJson(entity, URL + Constants.MM_SERVICE_STATE_LFG, User.class, user.getUsername());
	}

	@SuppressWarnings("unchecked")
	public static ResponseEntity<GameObject> getGame(User user) throws IOException
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		ResponseEntity<GameObject> response = getJson(URL + Constants.MM_SERVICE_GET_GAME, GameObject.class,
				user.getUsername());
		if (response.getStatusCode().equals(HttpStatus.OK))
		{
			return response;
		} else
		{
			return null;
		}
	}

}

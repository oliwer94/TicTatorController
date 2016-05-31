package com.jofa.utils;

public class Constants
{
//	URL CONSTRUCTION
	public static final String U_SERVICE_URL_PROP = "user.service.url";
	public static final String U_SERVICE_AUTHORIZE = "/authorize";
	public static final String U_SERVICE_REGISTER = "/register";
	public static final String U_SERVICE_FINDBYUSERNAME = "/findByUsername/{username}";
	public static final String U_SERVICE_LOGINATTEMPT = "/loginAttempt";
	
	public static final String CURRENT_USER = "currentUser";
	
	public static final String MM_SERVICE_URL_PROP = "matchmaking.service.url";
	public static final String MM_SERVICE_LOGOUT = "/logout/{username}";
	public static final String MM_SERVICE_REGISTER = "/register/{username}";
	public static final String MM_SERVICE_STATE_ONLINE = "/userStateONLINE/{username}";
	public static final String MM_SERVICE_STATE_LFG = "/userStateLFG/{username}";
	
	public static final String MM_SERVICE_GET_GAME = "/getGame/{username}";
	

}

package com.jofa.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.jofa.user.model.User;

@Controller
@RequestMapping("/controller")
public class TicTatorController {

	private static int counter = 0;
	private static final String VIEW_INDEX = "index";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(TicTatorController.class);

		
	@RequestMapping(method = RequestMethod.GET)
	public void welcome(ModelMap model) {

		logger.debug("I WAS TRYIN BOSS, I I I I I HAVE NO IDEA WHAT HAPPENED....");	
		// Spring uses InternalResourceViewResolver and return back index.jsp	

	}

	@RequestMapping(value = "/getUser/", method = RequestMethod.GET)
	public void test(ModelMap model) throws IOException {

		logger.debug("I WAS TRYIN BOSS, I I I I I HAVE NO IDEA WHAT HAPPENED....  GETUSER");	
		/*URL url = new URL("http://192.168.220.128:8080/TicTatorUser/user/1");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");

		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}

		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));

		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}

		conn.disconnect();
		*/
		RestTemplate restTemplate = new RestTemplate();
		User user = restTemplate.getForObject("http://192.168.220.128:8080/TicTatorUser/user/1", User.class);
		logger.debug(user.toString()+"WE DID IT BOSS");		
	}	
	
}
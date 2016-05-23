package com.jofa;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.jofa.simpleuser.SimpleUser;
import com.jofa.user.model.User;

public class UserFactoryTest {

	private static final String USERNAME = "Batman";
	private static final String PASSWORD = "Gotham <3";
	private SimpleUser simpleUser;
	
	@Before
	public void setUp() throws Exception {
		simpleUser = new SimpleUser(USERNAME, PASSWORD);
	}

	@Test
	public void test() {
		User user = UserFactory.createUser(simpleUser);
		assertEquals(USERNAME, user.getUsername());
		assertEquals(PASSWORD, user.getPassword());
	}

}

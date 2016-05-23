package com.jofa;

import com.jofa.simpleuser.SimpleUser;
import com.jofa.user.model.User;

public class UserFactory {

	public static User createUser(SimpleUser simpleUser) {
		return new User(0, "", simpleUser.getUsername(), simpleUser.getPassword(), false);
	}

}

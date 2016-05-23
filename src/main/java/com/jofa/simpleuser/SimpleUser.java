package com.jofa.simpleuser;

public class SimpleUser {
	private String username;
	private String password;
	private boolean admin;
	
	public SimpleUser() {
		super();
	}
	public SimpleUser(String username, String password,boolean admin) {
		super();
		this.username = username;
		this.password = password;
		this.admin = admin;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public boolean getAdmin() {
		return admin;
	}
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
}

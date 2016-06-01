package com.jofa.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

@XmlRootElement
@Entity
public class UserRoles implements java.io.Serializable, GrantedAuthority
{
	
	private static final long serialVersionUID = -2787167093972940166L;
	private int userId;
	private User user;
	private String role;

	public UserRoles()
	{
	}

	public UserRoles(User user, String role)
	{
		this.user = user;
		this.role = role;
	}

	@Id
	public int getUserId()
	{
		return this.userId;
	}

	public void setUserId(int userId)
	{
		this.userId = userId;
	}

	@JsonIgnore
	@XmlTransient
	public User getUser()
	{
		return this.user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	public String getRole()
	{
		return this.role;
	}

	public void setRole(String role)
	{
		this.role = role;
	}
	
	@Override
	public String getAuthority()
	{
		return this.role;
	}

}

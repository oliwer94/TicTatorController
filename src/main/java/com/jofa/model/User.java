package com.jofa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@XmlRootElement
@Entity
public class User implements java.io.Serializable, UserDetails
{

	private static final long serialVersionUID = -1596448129385958832L;
	private Integer id;
	private String email;
	private String username;
	private String password;
	private UserRoles userRoles;

	public User()
	{
	}

	public User(String email, String username, String password)
	{
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public User(String email, String username, String password, UserRoles userRoles)
	{
		this.email = email;
		this.username = username;
		this.password = password;
		this.userRoles = userRoles;
	}

	@Id
	public Integer getId()
	{
		return this.id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getEmail()
	{
		return this.email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getUsername()
	{
		return this.username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return this.password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public UserRoles getUserRoles()
	{
		return this.userRoles;
	}

	public void setUserRoles(UserRoles userRoles)
	{
		this.userRoles = userRoles;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		List<UserRoles> auths = new ArrayList<UserRoles>();
		auths.add(this.userRoles);
		return auths;
	}

	@Override
	public boolean isAccountNonExpired()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isAccountNonLocked()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isCredentialsNonExpired()
	{
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEnabled()
	{
		// TODO Auto-generated method stub
		return false;
	}

}

package com.jofa.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;

import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@Entity
public class LoginAttempt implements java.io.Serializable
{

	private static final long serialVersionUID = -2274506872798547691L;
	private Integer id;
	private String userName;
	private String userAgent;
	private boolean successful;
	private String ip;
	private Date attemptDate;

	public LoginAttempt()
	{
	}

	public LoginAttempt(String userName, String userAgent, boolean successful, String ip, Date attemptDate)
	{
		this.userName = userName;
		this.userAgent = userAgent;
		this.successful = successful;
		this.ip = ip;
		this.attemptDate = attemptDate;
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

	public String getUsername()
	{
		return this.userName;
	}

	public void setUsername(String userName)
	{
		this.userName = userName;
	}

	public String getUserAgent()
	{
		return this.userAgent;
	}

	public void setUserAgent(String userAgent)
	{
		this.userAgent = userAgent;
	}

	public boolean isSuccessful()
	{
		return this.successful;
	}

	public void setSuccessful(boolean successful)
	{
		this.successful = successful;
	}

	public String getIp()
	{
		return this.ip;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}
	
	public Date getAttemptDate() {
		return this.attemptDate;
	}

	public void setAttemptDate(Date attemptDate) {
		this.attemptDate = attemptDate;
	}

}

package de.mediaTracker.common.to.base;

import de.mediaTracker.common.enum_.UserRole;

public class UserTO extends AbstractTO
{

	private String userName;
	private String password;
	private UserRole userRole;

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public UserRole getUserRole()
	{
		return userRole;
	}

	public void setUserRole(UserRole userRole)
	{
		this.userRole = userRole;
	}
}
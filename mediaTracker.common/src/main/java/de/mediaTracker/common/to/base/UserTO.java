package de.mediaTracker.common.to.base;

import java.security.Principal;
import java.util.List;

public class UserTO extends AbstractTO implements Principal
{

	private String userName;
	private String password;
	private List<RoleTO> roles;

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

	public List<RoleTO> getRoles()
	{
		return roles;
	}

	public void setRoles(List<RoleTO> roles)
	{
		this.roles = roles;
	}

	@Override
	public String getName()
	{
		return userName;
	}
}
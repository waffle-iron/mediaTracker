package de.mediaTracker.webapp.security;

import java.security.Principal;

import javax.ws.rs.core.SecurityContext;

import de.mediaTracker.common.to.base.RoleTO;
import de.mediaTracker.common.to.base.UserTO;

public class MediaTrackerSecurityContext implements SecurityContext
{
	private static String SECURE = "https";

	private final UserTO user;

	public MediaTrackerSecurityContext(UserTO user)
	{
		this.user = user;
	}

	@Override
	public Principal getUserPrincipal()
	{
		return user;
	}

	@Override
	public boolean isUserInRole(String role)
	{
		for (RoleTO roleTO : user.getRoles())
		{
			if (roleTO.getRoleName().equals(role))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean isSecure()
	{
		return SECURE.equals(getAuthenticationScheme());
	}

	@Override
	public String getAuthenticationScheme()
	{
		return BASIC_AUTH;
	}

}

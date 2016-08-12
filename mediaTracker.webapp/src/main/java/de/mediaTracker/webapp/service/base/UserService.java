package de.mediaTracker.webapp.service.base;

import javax.inject.Inject;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.SecurityContext;

import de.mediaTracker.common.to.base.UserTO;
import de.mediaTracker.ejb.bo.api.IUserBO;
import de.mediaTracker.webapp.service.api.IUserService;

@Path("media")
public class UserService implements IUserService
{
	@Context
	SecurityContext securityContext;

	private final IUserBO userBO;

	@Inject
	public UserService(IUserBO userBO)
	{
		this.userBO = userBO;
	}

	@Override
	@POST
	@Path("/login")
	@Produces(MediaType.APPLICATION_JSON)
	// @RolesAllowed("guest")
	public boolean login(@PathParam("username") String username, @PathParam("password") String password)
	{
		if (null != username && null != password)
		{
			UserTO user = userBO.getUserByName(username);
			if (null != user && password.equals(user.getPassword()))
			{
			}

		}
		return false;
	}

	@Override
	@POST
	@Path("/register")
	@Produces(MediaType.APPLICATION_JSON)
	// @RolesAllowed("guest")
	public void register(String username, String password)
	{
		if (null != username && null != password)
		{

		}
	}

}

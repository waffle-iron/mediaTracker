package de.mediaTracker.webapp.security;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.List;
import java.util.StringTokenizer;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ResourceInfo;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;

import org.glassfish.jersey.internal.util.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import de.mediaTracker.ejb.bo.api.IUserBO;

@Provider
public class AuthenticationFilter implements ContainerRequestFilter
{
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationFilter.class);
	private static final String AUTHORIZATION_PROPERTY = "Authorization";
	private static final String AUTHENTICATION_SCHEME = "Basic";
	private static final Response ACCESS_DENIED = Response.status(Response.Status.UNAUTHORIZED).build();
	private static final Response ACCESS_FORBIDDEN = Response.status(Response.Status.FORBIDDEN).build();

	@Context
	private ResourceInfo resourceInfo;
	private final IUserBO userBO;

	public AuthenticationFilter(IUserBO userBO)
	{
		this.userBO = userBO;
	}

	@Override
	public void filter(ContainerRequestContext requestContext) throws IOException
	{
		Method method = resourceInfo.getResourceMethod();
		if (!method.isAnnotationPresent(PermitAll.class))
		{
			final MultivaluedMap<String, String> headers = requestContext.getHeaders();
			final List<String> authorization = headers.get(AUTHORIZATION_PROPERTY);

			if (authorization == null || authorization.isEmpty())
			{
				requestContext.abortWith(ACCESS_DENIED);
				return;
			}

			final String encodedUserPassword = authorization.get(0).replaceFirst(AUTHENTICATION_SCHEME + " ", "");

			// Decode username and password
			String usernameAndPassword = new String(Base64.decode(encodedUserPassword.getBytes()));
			;

			// Split username and password tokens
			final StringTokenizer tokenizer = new StringTokenizer(usernameAndPassword, ":");
			final String username = tokenizer.nextToken();
			final String password = tokenizer.nextToken();

			if (method.isAnnotationPresent(DenyAll.class))
			{
				LOGGER.warn(
						"Unerlaubter Zugriff auf Methode [{}] von Benutzer [{}]. Kein Zugriff auf diese Methode erlaubt",
						method.getName(), username);
				requestContext.abortWith(ACCESS_DENIED);
				return;
			}

			if (method.isAnnotationPresent(RolesAllowed.class))
			{
				RolesAllowed annotation = method.getAnnotation(RolesAllowed.class);

			}

		}

	}

}

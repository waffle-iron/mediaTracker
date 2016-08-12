package de.mediaTracker.webapp.application;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

import de.mediaTracker.webapp.security.AuthenticationFilter;

@ApplicationPath("webapi")
public class MediaTrackerApplication extends ResourceConfig
{
	public MediaTrackerApplication()
	{
		register(AuthenticationFilter.class);
	}
}

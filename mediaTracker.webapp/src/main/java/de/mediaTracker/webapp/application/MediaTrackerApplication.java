package de.mediaTracker.webapp.application;

import javax.ws.rs.ApplicationPath;
<<<<<<< HEAD

import org.glassfish.jersey.server.ResourceConfig;

import de.mediaTracker.webapp.security.AuthenticationFilter;

@ApplicationPath("webapi")
public class MediaTrackerApplication extends ResourceConfig
{
	public MediaTrackerApplication()
	{
		register(AuthenticationFilter.class);
	}
=======
import javax.ws.rs.core.Application;

@ApplicationPath("webapi")
public class MediaTrackerApplication extends Application
{

>>>>>>> branch 'teambox/v0.1' of https://fabianbloss@github.com/fabianbloss/mediaTracker.git
}

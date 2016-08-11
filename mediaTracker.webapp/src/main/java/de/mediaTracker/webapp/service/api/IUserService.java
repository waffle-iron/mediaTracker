package de.mediaTracker.webapp.service.api;

public interface IUserService extends IService
{
	public boolean login(String username, String password);

	public void register(String username, String password);
}

package de.mediaTracker.ejb.bo.api;

import java.util.List;

import de.mediaTracker.common.to.base.UserTO;

/**
 * 
 * @author fbloss
 *
 */
public interface IUserBO extends IBO
{
	public List<UserTO> getUsers();

	public UserTO getUserByName(String userName);

	public UserTO getUser(long userId);

	public UserTO saveUser(UserTO userTO);

	public void deleteUser(long userId);

}

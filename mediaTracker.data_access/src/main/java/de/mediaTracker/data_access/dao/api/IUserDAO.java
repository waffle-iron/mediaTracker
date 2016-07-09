package de.mediaTracker.data_access.dao.api;

import de.mediaTracker.common.exception.SystemException;
import de.mediaTracker.data_access.entity.base.UserEntity;

/**
 * DAO f�r die {@link UserEntity}
 * 
 * @author fbloss
 *
 */
public interface IUserDAO extends IEntityDAO<UserEntity>
{
	/**
	 * Sucht zu dem �bergebenen Usernamen die passende Entit�t
	 * 
	 * @param userName
	 *            Username des Benutzers
	 * @return {@link UserEntity}
	 * @throws SystemException
	 *             falls zu einem Usernamen mehr als eine {@link UserEntity}
	 *             gefunden wurde
	 */
	public UserEntity getUserByName(String userName) throws SystemException;
}

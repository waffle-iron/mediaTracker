package de.mediaTracker.data_access.dao.base;

import java.util.List;

import javax.persistence.TypedQuery;

import de.mediaTracker.common.exception.SystemException;
import de.mediaTracker.data_access.dao.api.IUserDAO;
import de.mediaTracker.data_access.entity.base.UserEntity;

public class UserDAO extends GenericDAO<UserEntity> implements IUserDAO
{
	@Override
	public UserEntity getUserByName(String userName) throws SystemException
	{
		TypedQuery<UserEntity> query = getEntityManager().createNamedQuery(UserEntity.QUERY_USER_FIND_ALL,
				UserEntity.class);
		query.setParameter("userName", userName);
		List<UserEntity> resultList = query.getResultList();
		if (resultList.size() > 1)
		{
			throw new SystemException("Es wurde mehr als ein User zum Username(Unique) " + userName + " gefunden.");
		}
		return resultList.get(0);
	}

	@Override
	protected Class<UserEntity> getEntityClass()
	{
		return UserEntity.class;
	}
}

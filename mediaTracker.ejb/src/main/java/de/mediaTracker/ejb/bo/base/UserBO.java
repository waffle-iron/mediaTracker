package de.mediaTracker.ejb.bo.base;

import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Inject;

import de.mediaTracker.common.to.base.UserTO;
import de.mediaTracker.data_access.dao.api.IUserDAO;
import de.mediaTracker.data_access.entity.base.UserEntity;
import de.mediaTracker.ejb.bo.api.IUserBO;
import de.mediaTracker.ejb.mapping.MappingUtil;

/**
 * 
 * @author fbloss
 *
 */
@Stateless
@Local(IUserBO.class)
public class UserBO implements IUserBO
{

	private final IUserDAO userDAO;

	/**
	 * Konstruktor
	 * 
	 * @param userDAO
	 */
	@Inject
	public UserBO(final IUserDAO userDAO)
	{
		this.userDAO = userDAO;
	}

	@Override
	public List<UserTO> getUsers()
	{
		List<UserEntity> userEntityList = userDAO.findAll();
		return MappingUtil.createTOList(userEntityList, UserTO.class);
	}

	@Override
	public UserTO getUser(long userId)
	{
		UserEntity userEntity = userDAO.find(userId);
	
		return MappingUtil.createTO(userEntity, UserTO.class);
	}

	@Override
	public UserTO getUserByName(String userName)
	{
		UserEntity userEntity = userDAO.getUserByName(userName);
		return MappingUtil.createTO(userEntity, UserTO.class);
	}

	@Override
	public UserTO saveUser(UserTO userTO)
	{
		UserEntity userEntity = MappingUtil.createEntity(userTO, UserEntity.class);
		userEntity = userDAO.save(userEntity);

		return MappingUtil.createTO(userEntity, UserTO.class);
	}

	@Override
	public void deleteUser(long userId)
	{
		userDAO.delete(userId);
	}

}

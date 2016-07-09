package de.mediaTracker.ejb.bo;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import de.mediaTracker.common.enum_.UserRole;
import de.mediaTracker.common.to.base.UserTO;
import de.mediaTracker.data_access.dao.base.UserDAO;
import de.mediaTracker.data_access.entity.base.UserEntity;
import de.mediaTracker.ejb.bo.base.UserBO;

public class UserBOTest
{

	private final static UserDAO userDAO = mock(UserDAO.class);
	private final static UserBO userBO = new UserBO(userDAO);

	private final static long USER_ID = 1;
	private final static String USERNAME = "Fabian";
	private final static String PASSWORD = "123";
	private final static UserRole USER_ROLE = UserRole.USER;

	private final static long USER_ID2 = 2;
	private final static String USERNAME2 = "Katharina";
	private final static String PASSWORD2 = "456";
	private final static UserRole USER_ROLE2 = UserRole.GUEST;

	@Test
	public void testGetUser()
	{
		when(userDAO.find(USER_ID)).thenReturn(createUserEntity(USER_ID, USERNAME, PASSWORD, USER_ROLE));

		UserTO userTO = userBO.getUser(USER_ID);

		assertThat(userTO, is(notNullValue()));
		assertThat(userTO.getId(), is(USER_ID));
		assertThat(userTO.getUserName(), is(USERNAME));
		assertThat(userTO.getPassword(), is(PASSWORD));
		assertThat(userTO.getUserRole(), is(USER_ROLE));
	}

	@Test
	public void testSaveUser()
	{
		when(userDAO.save(any(UserEntity.class))).thenReturn(createUserEntity(USER_ID, USERNAME, PASSWORD, USER_ROLE));

		UserTO result = userBO.saveUser(createUserTO(null, USERNAME, PASSWORD, USER_ROLE));

		assertThat(result, is(notNullValue()));
		assertThat(result.getId(), is(USER_ID));
		assertThat(result.getUserName(), is(USERNAME));
		assertThat(result.getPassword(), is(PASSWORD));
		assertThat(result.getUserRole(), is(USER_ROLE));
	}

	@Test
	public void testGetUsers()
	{
		List<UserEntity> userEntityList = new ArrayList<>();
		userEntityList.add(createUserEntity(USER_ID, USERNAME, PASSWORD, USER_ROLE));
		userEntityList.add(createUserEntity(USER_ID2, USERNAME2, PASSWORD2, USER_ROLE2));

		when(userDAO.findAll()).thenReturn(userEntityList);

		List<UserTO> userTOList = userBO.getUsers();

		assertThat(userTOList, is(notNullValue()));
		assertThat(userTOList, hasSize(2));

		for (UserTO userTO : userTOList)
		{
			if (USER_ID == userTO.getId())
			{
				assertThat(userTO.getUserName(), is(USERNAME));
				assertThat(userTO.getPassword(), is(PASSWORD));
				assertThat(userTO.getUserRole(), is(USER_ROLE));
			}
			else if (USER_ID2 == userTO.getId())
			{
				assertThat(userTO.getUserName(), is(USERNAME2));
				assertThat(userTO.getPassword(), is(PASSWORD2));
				assertThat(userTO.getUserRole(), is(USER_ROLE2));
			}
			else
			{
				fail("User Id konnte nicht zugeordnet werden.");
			}
		}
	}

	private UserEntity createUserEntity(Long id, String userName, String password, UserRole role)
	{
		UserEntity user = new UserEntity();
		user.setId(id);
		user.setUserName(userName);
		user.setPassword(password);
		user.setUserRole(role);

		return user;
	}

	private UserTO createUserTO(Long id, String userName, String password, UserRole role)
	{
		UserTO user = new UserTO();
		user.setId(id);
		user.setUserName(userName);
		user.setPassword(password);
		user.setUserRole(role);

		return user;
	}

}
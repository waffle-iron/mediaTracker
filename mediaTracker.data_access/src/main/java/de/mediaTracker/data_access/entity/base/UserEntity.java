package de.mediaTracker.data_access.entity.base;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import de.mediaTracker.common.enum_.UserRole;
import de.mediaTracker.data_access.entity.api.AbstractEntity;

/**
 * Entity implementation class for Entity: User
 *
 */
@Entity
@Table(name = "USER")
@NamedQueries({
		@NamedQuery(name = UserEntity.QUERY_USER_FIND_ALL, query = "SELECT u FROM UserEntity u WHERE u.userName = :userName") })
public class UserEntity extends AbstractEntity implements Serializable
{
	public final static String QUERY_USER_FIND_ALL = "UserEntity.findByName";

	private static final long serialVersionUID = 1L;

	@Column(name = "USERNAME", length = 100, nullable = false)
	private String userName;

	@Column(name = "PASSWORD", length = 256, nullable = false)
	private String password;

	@Column(name = "USERROLE", length = 1, nullable = true)
	private UserRole userRole;

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public UserRole getUserRole()
	{
		return userRole;
	}

	public void setUserRole(UserRole userRole)
	{
		this.userRole = userRole;
	}
}

package de.mediaTracker.data_access.entity.base;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

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

	@ManyToMany
	@JoinTable(name = "USER_ROLE", joinColumns = { @JoinColumn(name = "USER_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "ROLE_ID") })
	private List<RoleEntity> roles;

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

	public List<RoleEntity> getRoles()
	{
		return roles;
	}

	public void setRoles(List<RoleEntity> roles)
	{
		this.roles = roles;
	}
}

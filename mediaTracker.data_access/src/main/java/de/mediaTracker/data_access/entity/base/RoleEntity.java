package de.mediaTracker.data_access.entity.base;

import javax.persistence.Entity;
import javax.persistence.Table;

import de.mediaTracker.data_access.entity.api.AbstractEntity;

@Entity
@Table(name = "ROLES")
public class RoleEntity extends AbstractEntity
{
	private static final long serialVersionUID = 1L;

	private String roleName;

	public String getRoleName()
	{
		return roleName;
	}

	public void setRoleName(String roleName)
	{
		this.roleName = roleName;
	}
}

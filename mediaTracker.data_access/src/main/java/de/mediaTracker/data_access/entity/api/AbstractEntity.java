package de.mediaTracker.data_access.entity.api;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * Entity implementation class for Entity: AbstractEntity
 *
 */
@MappedSuperclass
public class AbstractEntity implements Serializable
{

	private static final long serialVersionUID = 1L;

	@Id
	private Long id;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}
}

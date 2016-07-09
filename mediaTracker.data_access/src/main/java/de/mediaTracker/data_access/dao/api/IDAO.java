package de.mediaTracker.data_access.dao.api;

import javax.persistence.EntityManager;

public interface IDAO
{

	public EntityManager getEntityManager();

	public void setEntityManager(EntityManager entityManager);

}

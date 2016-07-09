package de.mediaTracker.data_access.dao.base;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import de.mediaTracker.common.exception.ObjectNotFoundException;
import de.mediaTracker.data_access.dao.api.IEntityDAO;
import de.mediaTracker.data_access.entity.api.AbstractEntity;

public abstract class GenericDAO<Entity extends AbstractEntity> implements IEntityDAO<Entity>
{

	private EntityManager entityManager;

	/**
	 * @return die {@link Class} der verwalteten Entitäten
	 */
	protected abstract Class<Entity> getEntityClass();

	/**
	 * @return the {@link EntityManager}
	 */
	public EntityManager getEntityManager()
	{
		return entityManager;
	}

	/**
	 * @param entityManager
	 *            zum injecten
	 */
	@PersistenceContext
	public void setEntityManager(EntityManager entityManager)
	{
		this.entityManager = entityManager;
	}

	public Entity find(Long id) throws IllegalArgumentException, ObjectNotFoundException
	{
		Entity entity = entityManager.find(getEntityClass(), id);
		if (entity == null)
			throw new ObjectNotFoundException(getEntityClass(), String.valueOf(id));
		return entity;
	}

	public List<Entity> findAll()
	{
		CriteriaQuery<Entity> query = entityManager.getCriteriaBuilder().createQuery(getEntityClass());
		Root<Entity> root = query.from(getEntityClass());
		query.select(root);
		TypedQuery<Entity> typedQuery = this.entityManager.createQuery(query);
		List<Entity> resultList = typedQuery.getResultList();
		return resultList;
	}

	public Entity save(Entity entity)
	{
		if (isNew(entity))
		{
			entityManager.persist(entity);
			return entity;
		}
		else
		{
			entityManager.merge(entity);
			return entity;
		}
	}

	public void save(Iterable<? extends Entity> entities)
	{
		for (Entity entity : entities)
		{
			save(entity);
		}
	}

	public void delete(Entity entity)
	{
		entityManager.remove(entity);
	}

	public void delete(Long id) throws IllegalArgumentException
	{
		Entity entity = entityManager.getReference(getEntityClass(), id);
		entityManager.remove(entity);
	}

	public void delete(Iterable<? extends Entity> entities)
	{
		for (Entity entity : entities)
		{
			delete(entity);
		}
	}

	public boolean exists(Long id)
	{
		return find(id) != null;
	}

	/**
	 * Prüft ob die Entität bereits gespeichert ist
	 * 
	 * @param entity
	 *            die geprüft werden soll
	 * @return <b>{@literal true}</b> wenn die {@code AbstractEntity Entität}
	 *         nocht nicht gespeichert wurde, <b>{@literal false}</b> wenn sie
	 *         bereits gespeichert wurde
	 */
	private boolean isNew(Entity entity)
	{
		return entity.getId() == null ? true : false;
	}
}

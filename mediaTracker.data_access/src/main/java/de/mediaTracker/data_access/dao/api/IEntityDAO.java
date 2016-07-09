package de.mediaTracker.data_access.dao.api;

import java.util.List;

import de.mediaTracker.data_access.entity.api.AbstractEntity;

public interface IEntityDAO<Entity extends AbstractEntity> extends IDAO
{
	/**
	 * Gibt eine Entit�t anhand ihrer Id zur�ck
	 * 
	 * @param id
	 *            darf nicht <b>{@code null}</b> sein
	 * @return die Entit�t mit der gegebenen Id oder null wenn keine gefunden
	 *         wurde
	 * @throws IllegalArgumentException
	 *             wenn Id <b>{@code null}</b> ist
	 * @throws ObjectNotFoundUserException
	 * @throws ObjectNotFoundException
	 */
	public Entity find(Long id) throws IllegalArgumentException;

	/**
	 * Gibt alle Entit�ten zur�ck.
	 * 
	 * @return {@link List Liste} aller Entit�ten
	 */
	public List<Entity> findAll();

	/**
	 * Speichert die �bergebene {@code AbstractEntity Entit�t}
	 * 
	 * @param entity
	 *            die gespeichert werden soll
	 * @return die gespeicherte Entit�t
	 */
	public Entity save(Entity entity);

	/**
	 * Speichert eine {@link Iterable} an {@code AbstractEntity Entit�ten}
	 * 
	 * @param entities
	 *            die gespeichert werden sollen
	 */
	public void save(Iterable<? extends Entity> entities);

	/**
	 * L�scht die �bergebene {@code AbstractEntity Entit�t}
	 * 
	 * @param entity
	 *            die gel�scht werden soll
	 */
	public void delete(Entity entity);

	/**
	 * L�scht eine {@code AbstractEntity Entit�t} anhand ihrer Id
	 * 
	 * @param id
	 *            der zu l�schenden Entit�t
	 * @throws IllegalArgumentException
	 *             falls die {@code id} <b>{@code null}</b> ist
	 */
	public void delete(Long id) throws IllegalArgumentException;

	/**
	 * L�scht die �bergebenen {@code AbstractEntity Entit�ten}
	 * 
	 * @param entities
	 *            {@code Iterable} aller zu l�schenden
	 *            {@code AbstractEntity Entit�ten}
	 */
	public void delete(Iterable<? extends Entity> entities);

	/**
	 * Pr�ft ob eine {@code AbstractEntity Entit�t} mit der gegebenen Id
	 * existiert
	 * 
	 * @param id
	 *            der zu pr�fenden {@code AbstractEntity Entit�t}
	 * @return <b>{@literal true}</b> wenn die {@code AbstractEntity Entit�t}
	 *         existiert, <b>{@literal false}</b> wenn nicht
	 */
	public boolean exists(Long id);
}

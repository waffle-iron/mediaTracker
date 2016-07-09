package de.mediaTracker.data_access.dao.api;

import java.util.List;

import de.mediaTracker.data_access.entity.api.AbstractEntity;

public interface IEntityDAO<Entity extends AbstractEntity> extends IDAO
{
	/**
	 * Gibt eine Entität anhand ihrer Id zurück
	 * 
	 * @param id
	 *            darf nicht <b>{@code null}</b> sein
	 * @return die Entität mit der gegebenen Id oder null wenn keine gefunden
	 *         wurde
	 * @throws IllegalArgumentException
	 *             wenn Id <b>{@code null}</b> ist
	 * @throws ObjectNotFoundUserException
	 * @throws ObjectNotFoundException
	 */
	public Entity find(Long id) throws IllegalArgumentException;

	/**
	 * Gibt alle Entitäten zurück.
	 * 
	 * @return {@link List Liste} aller Entitäten
	 */
	public List<Entity> findAll();

	/**
	 * Speichert die übergebene {@code AbstractEntity Entität}
	 * 
	 * @param entity
	 *            die gespeichert werden soll
	 * @return die gespeicherte Entität
	 */
	public Entity save(Entity entity);

	/**
	 * Speichert eine {@link Iterable} an {@code AbstractEntity Entitäten}
	 * 
	 * @param entities
	 *            die gespeichert werden sollen
	 */
	public void save(Iterable<? extends Entity> entities);

	/**
	 * Löscht die übergebene {@code AbstractEntity Entität}
	 * 
	 * @param entity
	 *            die gelöscht werden soll
	 */
	public void delete(Entity entity);

	/**
	 * Löscht eine {@code AbstractEntity Entität} anhand ihrer Id
	 * 
	 * @param id
	 *            der zu löschenden Entität
	 * @throws IllegalArgumentException
	 *             falls die {@code id} <b>{@code null}</b> ist
	 */
	public void delete(Long id) throws IllegalArgumentException;

	/**
	 * Löscht die übergebenen {@code AbstractEntity Entitäten}
	 * 
	 * @param entities
	 *            {@code Iterable} aller zu löschenden
	 *            {@code AbstractEntity Entitäten}
	 */
	public void delete(Iterable<? extends Entity> entities);

	/**
	 * Prüft ob eine {@code AbstractEntity Entität} mit der gegebenen Id
	 * existiert
	 * 
	 * @param id
	 *            der zu prüfenden {@code AbstractEntity Entität}
	 * @return <b>{@literal true}</b> wenn die {@code AbstractEntity Entität}
	 *         existiert, <b>{@literal false}</b> wenn nicht
	 */
	public boolean exists(Long id);
}

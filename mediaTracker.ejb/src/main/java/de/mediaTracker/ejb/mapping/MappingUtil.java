package de.mediaTracker.ejb.mapping;

import java.util.ArrayList;
import java.util.List;

import org.dozer.DozerBeanMapper;
import org.dozer.Mapper;

import de.mediaTracker.common.to.base.AbstractTO;
import de.mediaTracker.data_access.entity.api.AbstractEntity;

public class MappingUtil
{
	public static final Mapper MAPPER = new DozerBeanMapper();

	/**
	 * Wandelt ein TO Object in eine Entity Object um
	 * 
	 * @param source
	 *            TO Objekt, welches von {@link AbstractTO} erben muss
	 * @param destType
	 *            Entity Klasse, die von {@link AbstractEntity} erben muss
	 * @return neues Enität Objekt
	 */
	public static <T extends AbstractTO, E extends AbstractEntity> E createEntity(final T source,
			final Class<E> destType)
	{
		return MAPPER.map(source, destType);
	}

	/**
	 * Wandelt ein Entität Object in ein TO Object um
	 * 
	 * @param source
	 *            Entity Klasse die von {@link AbstractEntity} erben muss
	 * @param destType
	 *            TO Klasse, die von {@link AbstractTO} erben muss
	 * @return neues TO Objekt
	 */
	public static <T extends AbstractTO, E extends AbstractEntity> T createTO(final E source, final Class<T> destType)
	{
		return MAPPER.map(source, destType);
	}

	/**
	 * Wandelt eine Liste von TOs in eine Liste von Entitäten um
	 * 
	 * @param sourceList
	 *            Liste von TOs die von {@link AbstractTO} erben müssen
	 * @param destType
	 *            Entität Klasse, die von {@link AbstractTO} erben muss
	 * @return
	 */
	public static <T extends AbstractTO, E extends AbstractEntity> List<E> createEntityList(final List<T> sourceList,
			final Class<E> destType)
	{
		final List<E> result = new ArrayList<>();

		for (T sourceElement : sourceList)
		{
			if (sourceElement == null)
			{
				continue;
			}
			result.add(createEntity(sourceElement, destType));
		}

		return result;
	}

	/**
	 * Wandelt eine Liste von Enitäten in eine Liste von TOs um
	 * 
	 * @param sourceList
	 *            Liste von Entitäten die von {@link AbstractEntity} erben
	 *            müssen
	 * @param destType
	 *            TO Klasse, die von {@link AbstractTO} erben muss
	 * @return
	 */
	public static <T extends AbstractTO, E extends AbstractEntity> List<T> createTOList(final List<E> sourceList,
			final Class<T> destType)
	{
		final List<T> result = new ArrayList<>();

		for (E sourceElement : sourceList)
		{
			if (sourceElement == null)
			{
				continue;
			}
			result.add(createTO(sourceElement, destType));
		}

		return result;
	}
}

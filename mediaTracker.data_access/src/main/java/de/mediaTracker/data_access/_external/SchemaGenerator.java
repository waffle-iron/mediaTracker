package de.mediaTracker.data_access._external;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.Persistence;

import org.eclipse.persistence.jpa.PersistenceProvider;

public class SchemaGenerator
{
	private static final Class<PersistenceProvider> PERSISTENCE_PROVIDER = PersistenceProvider.class;

	private static final String PERSISTENCE_UNIT = "SERIENTRACKER_MANUAL";
	
	public static void main(String[] args)
	{
		Map<String, Class<PersistenceProvider>> map = new HashMap<>();
		map.put("javax.persistence.provider", PERSISTENCE_PROVIDER);
		Persistence.generateSchema(PERSISTENCE_UNIT, map);
	}
}

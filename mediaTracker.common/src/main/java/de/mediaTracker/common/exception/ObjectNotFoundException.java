package de.mediaTracker.common.exception;

/**
 * Exception die auftritt sobald ein Object in der Datenbank beispielsweise
 * anhand des Keys(ID) nicht gefunden werden konnte.
 * 
 * @author Fabi
 *
 */
public class ObjectNotFoundException extends RuntimeException
{

	private static final long serialVersionUID = 1L;

	private final Object object;
	private final String key;

	public ObjectNotFoundException(Object object, String key)
	{
		super("Objekt " + object.getClass().getSimpleName() + " mit der ID " + key + " konnte nicht gefunden werden.");
		this.object = object;
		this.key = key;
	}

	public Object getObject()
	{
		return object;
	}

	public String getKey()
	{
		return key;
	}
}

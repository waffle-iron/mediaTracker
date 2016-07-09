package de.mediaTracker.common.exception;

/**
 * Unchecked Exception bei technischen Fehlern
 * 
 * @author fbloss
 *
 */
public class SystemException extends RuntimeException
{
	private static final long serialVersionUID = 1L;

	public SystemException(Throwable t, String message)
	{
		super(message, t);
	}

	public SystemException(String message)
	{
		super(message);
	}

	public SystemException(Throwable t)
	{
		super(t);
	}

	public SystemException()
	{
	}
}

package de.mediaTracker.common.enum_;

public enum UserRole
{

	GUEST(0), USER(1), ADMIN(2);

	private int ordinal;

	private UserRole(int ordinal)
	{
		this.ordinal = ordinal;
	}

	public int getOrdinal()
	{
		return ordinal;
	}

}

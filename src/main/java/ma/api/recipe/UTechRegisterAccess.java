package ma.api.recipe;

public final class UTechRegisterAccess
{
	private static IUTechRegister register;

	/**
	 * Get definition of Technology from register.
	 *
	 * @param key	register key
	 *
	 * @return 		define of Technology
	 */
	public static Technology getTechnology (String key)
	{
		return register.getTechnology(key);
	}

	/**
	 * Register new define of Technology.
	 *
	 * @param key		register key
	 * @param name		Name of Technology
	 * @param maxLevel	Maximum-Level of Technology
	 * @return			If the registration key duplicated , false is returned.
	 */
	public static boolean registerTechnology (String key, String name, short maxLevel)
	{
		return register.registerTechnology(key, name, maxLevel);
	}

	/**
	 * Register new define of Technology.
	 *
	 * @param key		register key
	 * @param tech		define of Technology
	 * @return			If the registration key duplicated , false is returned.
	 */
	public static boolean registerTechnology (String key, Technology tech)
	{
		return register.registerTechnology(key, tech);
	}

	public static interface IUTechRegister
	{
		Technology getTechnology (String key);

		boolean registerTechnology (String key, String name, short maxLevel);

		boolean registerTechnology (String key, Technology tech);
	}
}
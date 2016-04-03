package ma.api.smaterial;

/**
 * Accesser of SMatRegistry
 *
 * @author	licht
 */
public final class SMatRegistryAccess
{
	private static ISMatRegistry registry;

	/**
	 * Register SMaterial to registry.
	 *
	 * @param sMaterial	register hasMaterial
	 *
	 * @return	If the registration is duplicated , return false.
	 */
	public static boolean registerMaterial (SMaterial sMaterial)
	{
		return registry.registerMaterial(sMaterial);
	}

	/**
	 * To get the definition of SMaterial from registry.
	 *
	 * @param name	register name
	 *
	 * @return	Definition of SMaterial
	 */
	public static SMaterial getMaterial (String name)
	{
		return registry.getMaterial(name);
	}

	public interface ISMatRegistry
	{
		boolean registerMaterial (SMaterial sMaterial);

		SMaterial getMaterial (String name);
	}
}
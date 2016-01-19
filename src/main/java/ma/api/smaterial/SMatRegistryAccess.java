package ma.api.smaterial;

public final class SMatRegistryAccess
{
	private static ISMatRegistry registry;

	public static boolean registerMaterial (SMaterial sMaterial)
	{
		return registry.registerMaterial(sMaterial);
	}

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
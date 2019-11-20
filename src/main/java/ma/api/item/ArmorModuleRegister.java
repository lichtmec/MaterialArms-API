package ma.api.item;

import ma.api.MaterialArmsAPI;

public class ArmorModuleRegister
{
	private static IArmorModuleRegister REGISTER;

	public static void registerArmorModule (String key, IMountedModule moduleProperty)
	{
		if (REGISTER == null)
		{
			MaterialArmsAPI.sendLogFatal("MaterialArms core is not functioning.");
			return;
		}

		REGISTER.registerArmorModule(key, moduleProperty);
	}

	public static void registerArmorCompositeModule (IMountedModuleComposite.IMatcher matcher, IMountedModuleComposite compositeModuleProperty)
	{
		if (REGISTER == null)
		{
			MaterialArmsAPI.sendLogFatal("MaterialArms core is not functioning.");
			return;
		}

		REGISTER.registerArmorCompositeModule(matcher, compositeModuleProperty);
	}

	public interface IArmorModuleRegister
	{
		void registerArmorModule (String key, IMountedModule moduleProperty);

		void registerArmorCompositeModule (IMountedModuleComposite.IMatcher matcher, IMountedModuleComposite compositeModuleProperty);
	}
}
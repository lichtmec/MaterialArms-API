package ma.api.item;

/**
 * Container-class for tool modification info.<br>
 * <br>
 * <b>Parameters</b><br>
 * modClass -> modification type ... ex) custom, enchant<br>
 * targetItemClass -> target tool type ... ex) tool, armor<br>
 * modName -> modification name ... ex) shapeness, reinforce
 *
 * @author	licht
 */
public class ModConform
{
	public final String modClass;
	public final String targetItemClass;
	public final String modName;
	
	public ModConform (String modClass, String targetItemClass, String modName)
	{
		this.modClass = modClass;
		this.targetItemClass = targetItemClass;
		this.modName = modName;
	}

	@SuppressWarnings("unused")
	public boolean isConform (String modName)
	{
		return this.modName.equals(modName);
	}

	@SuppressWarnings("unused")
	public boolean isConform (String targetItemClass, String modName)
	{
		return this.targetItemClass.equals(targetItemClass) && isConform(modName);
	}

	@SuppressWarnings("unused")
	public boolean isConform (String modClass, String targetItemClass, String modName)
	{
		return this.modClass.equals(modClass) && isConform(targetItemClass, modName);
	}
	
	public boolean equals (ModConform mc)
	{
		return this.toString().equals(mc.toString());
	}
	
	public String toString ()
	{
		return modClass + "." + targetItemClass + "." + modName;
	}
}
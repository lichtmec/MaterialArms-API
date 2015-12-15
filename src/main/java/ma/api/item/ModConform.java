package ma.api.item;

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
	
	public boolean isConform (String modName)
	{
		return this.modName.equals(modName);
	}
	
	public boolean isConform (String targetItemClass, String modName)
	{
		return this.targetItemClass.equals(targetItemClass) && isConform(modName);
	}
	
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
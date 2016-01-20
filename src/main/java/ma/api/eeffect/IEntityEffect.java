package ma.api.eeffect;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;

@Deprecated
public interface IEntityEffect
{
	public boolean canApply (Entity target);

	public void updateEffect (Entity entity, NBTTagCompound data);

	public void postUpdate (Entity entity, NBTTagCompound data);
}
package ma.api.eeffect;

import net.minecraft.entity.Entity;

public interface IEntityEffect
{
	public boolean canApply (Entity target);

	public void updateEffect (Entity entity);
}
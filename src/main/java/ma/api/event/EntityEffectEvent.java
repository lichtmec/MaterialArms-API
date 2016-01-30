package ma.api.event;

import cpw.mods.fml.common.eventhandler.Cancelable;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.entity.EntityEvent;
import ma.api.eeffect.IEntityEffect;

/**
 * Event of EntityEffect.
 *
 * @author	licht
 */
public abstract class EntityEffectEvent extends EntityEvent
{
	protected IEntityEffect effect;
	protected NBTTagCompound data;

	public EntityEffectEvent (Entity entity, IEntityEffect effect, NBTTagCompound data)
	{
		super(entity);

		this.effect = effect;
		this.data = data;
	}

	public IEntityEffect getEffect ()
	{
		return this.effect;
	}

	public NBTTagCompound getEffectData ()
	{
		return this.data;
	}

	@Cancelable
	public static final class ApplyEvent extends EntityEffectEvent
	{
		public ApplyEvent (Entity entity, IEntityEffect effect, NBTTagCompound data)
		{
			super(entity, effect, data);
		}
	}

	public static final class RemovalEvent extends EntityEffectEvent
	{
		public RemovalEvent (Entity entity, IEntityEffect effect, NBTTagCompound data)
		{
			super(entity, effect, data);
		}
	}
}
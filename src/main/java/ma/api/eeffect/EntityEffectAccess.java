package ma.api.eeffect;

import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;

public final class EntityEffectAccess
{
	private static IEntityEffectManager manager;

	public static boolean registerEffect (String key, IEntityEffect effect)
	{
		return manager.registerEffect(key, effect);
	}

	public static IEntityEffect getEffect (String key)
	{
		return manager.getEffect(key);
	}

	public static void applyEffect (Entity entity, String effectKey)
	{
		manager.applyEffect(entity, effectKey);
	}

	public static void applyEffect (Entity target, String effectKey, NBTTagCompound data)
	{
		manager.applyEffect(target, effectKey, data);
	}

	public static void setEffectInvalidFlag (Entity target, String effectKey)
	{
		manager.setEffectInvalidFlag(target, effectKey);
	}

	public static void syncEffectData (Entity entity)
	{
		manager.syncEffectData(entity);
	}

	public interface IEntityEffectManager
	{
		boolean registerEffect (String key, IEntityEffect effect);

		IEntityEffect getEffect (String key);

		void applyEffect (Entity target, String effectKey);

		void applyEffect (Entity target, String effectKey, NBTTagCompound data);

		void setEffectInvalidFlag (Entity target, String effectKey);

		void syncEffectData (Entity entity);
	}
}
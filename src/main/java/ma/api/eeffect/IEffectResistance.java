package ma.api.eeffect;

import net.minecraft.nbt.NBTTagCompound;

/**
 * Interface for Entity.
 * To define the resistance to EntityEffect.
 *
 * @author	licht
 */
public interface IEffectResistance
{
	/**
	 * Check to there has resistance.
	 *
	 * @param effect	Defined class of EntityEffect
	 * @param data		EntityEffect data
	 *
	 * @return			resistant
	 */
	boolean canResist (IEntityEffect effect, NBTTagCompound data);
}
package ma.api.eeffect;

import cpw.mods.fml.relauncher.Side;
import net.minecraft.entity.Entity;
import net.minecraft.nbt.NBTTagCompound;

/**
 * Interface for defined class of EntityEffect.
 *
 * @author	licht
 */
public interface IEntityEffect
{
	/**
	 * Check whether effect is valid.
	 * If this is invalid, automatically delete that.
	 *
	 * @param target	Entity who has been applyed
	 * @param data		EntityEffect data
	 *
	 * @return	true(valid) or false(invalid)
	 */
	boolean isValid (Entity target, NBTTagCompound data);

	/**
	 * Check whether effect can apply.
	 *
	 * @param target	Entity to be applyed
	 * @param data		EntityEffect data
	 *
	 * @return	true(can not) or false(can)
	 */
	boolean canApply (Entity target, NBTTagCompound data);

	/**
	 * EntityEffect update process.
	 * It called on server side only.
	 *
	 * @param entity	Entity who has been applyed
	 * @param data		EntityEffect data
	 */
	void updateEffect (Entity entity, NBTTagCompound data);

	/**
	 * Check whether it contains the attributes in EntityEffect.
	 *
	 * @param attribute	EffectAttribute
	 *
	 * @return	true(contain) or false(not contain)
	 */
	boolean containAttribute (IEffectAttribute attribute);

	interface IEffectAttribute
	{
	}
}
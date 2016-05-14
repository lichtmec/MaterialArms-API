package ma.api.item;

import net.minecraft.item.ItemStack;

/**
 * @author	licht
 */
public interface IDamageableItemMA_2 extends IDamageableItemMA
{
	/**
	 * If it returns true, the process of adding the damage is skipped.
	 *
	 * @return	true(damageable) or false(not damageable)
	 */
	public boolean isDamageableItem (ItemStack stack);
}
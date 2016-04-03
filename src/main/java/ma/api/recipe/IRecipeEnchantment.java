package ma.api.recipe;

import net.minecraft.item.*;

/**
 * Recipe of MA-Enchantment.
 *
 * @author	licht
 */
public interface IRecipeEnchantment
{
	/**
	 * If it returns true, accept IEnchantableItemMA only as target.
	 *
	 * @return	true or false
	 */
	boolean enchantableOnly ();

	/**
	 * Check whether they match a recipe.
	 *
	 * @param target		Target of enchantment
	 * @param inputStack	Resources of enchantment
	 *
	 * @return	Is matched
	 */
	boolean isMatch (ItemStack target, ItemStack[] inputStack);

	/**
	 * Returns the resource of enchantment.
	 *
	 * @return	Resource of enchantment
	 */
	Object[] getResources ();

	/**
	 * Return an enchantment result.
	 *
	 * @param target		Target of enchantment
	 * @param inputStack	Resources of enchantment
	 *
	 * @return	Result of enchantment.
	 */
	ItemStack getOutput (ItemStack target, ItemStack[] inputStack);
}
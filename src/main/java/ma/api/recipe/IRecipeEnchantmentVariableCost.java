package ma.api.recipe;

import net.minecraft.item.ItemStack;

/**
 * Interface that allows change the start-up cost of the Enchanter.
 *
 * @author	licht
 */
public interface IRecipeEnchantmentVariableCost extends IRecipeEnchantment
{
	/**
	 * Return the start-up cost.
	 * Negative values can also be specified.
	 *
	 * @param target		Target of enchantment
	 * @param inputStack	Resources of enchantment
	 *
	 * @return	Start-up cost of Enchanter
	 */
	int getEnchantCost (ItemStack target, ItemStack[] inputStack);
}
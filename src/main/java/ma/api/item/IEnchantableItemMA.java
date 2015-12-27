package ma.api.item;

import net.minecraft.item.*;

/**
 * Interface of the tool support to the enchantment.
 *
 * @author licht
 */
public interface IEnchantableItemMA
{
	/**
	 * @return	Acceptable enchant strength
	 */
	int getRuneCapacity (ItemStack stack);

	/**
	 * @return	Maximum storage amount of Mana
	 */
	int getManaCapacity (ItemStack stack);

	/**
	 * Does this stack support to enchantment.
	 *
	 * @param	stack	Stack to confirm.
	 *
	 * @return	is support
	 */
	boolean isProvideConformInfo_Enchantment (ItemStack stack);

	/**
	 * Is it possible to perform the modification.
	 *
	 * @param	stack	Stack to confirm.
	 * @param	modInfo	Modification type.
	 * @param	input	Input stacks of EnchantTableMA.
	 *
	 * @return	possible
	 */
	boolean isConform_Enchantment (ItemStack stack, ModConform modInfo, ItemStack[] input);
}
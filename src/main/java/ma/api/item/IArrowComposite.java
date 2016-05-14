package ma.api.item;

import net.minecraft.item.ItemStack;

/**
 * Item-Arrow to be used in the CompositeBow.
 *
 * @author	licht
 */
public interface IArrowComposite
{
	/**
	 * @param stack	Stack of target
	 *
	 * @return true(can use) or false(can not)
	 */
	boolean canUseToCompositeBow (ItemStack stack);

	/**
	 * @param stack	Stack of arrow
	 *
	 * @return	Is attached arrowhead
	 */
	boolean hasArrowhead (ItemStack stack);

	/**
	 * @param stack	Stack of arrow
	 *
	 * @return	Colormask of arrowhead
	 */
	int getArrowheadColor (ItemStack stack);

	/**
	 * @param stack	Stack of arrow
	 *
	 * @return	Is attached arrow-feathers
	 */
	boolean hasFeathers (ItemStack stack);

	/**
	 * @param stack	Stack of arrow
	 *
	 * @return	Colormask of feathers
	 */
	int getFeathersColor (ItemStack stack);

	/**
	 * Return the base-damage of arrow.<br>
	 * base-damage : Doesn't include the effect of such customization and enchantment.
	 *
	 * @param stack	Stack of arrow
	 *
	 * @return	Base damage of arrow
	 */
	float getBaseDamage (ItemStack stack);
}
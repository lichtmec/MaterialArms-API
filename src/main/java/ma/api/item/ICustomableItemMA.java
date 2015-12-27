package ma.api.item;

import net.minecraft.item.*;

/**
 * Interface of the tool support to the customize.
 *
 * @author licht
 */
public interface ICustomableItemMA
{
	/**
	 * Does this stack support to customize.
	 *
	 * @param	stack	Stack to confirm.
	 *
	 * @return	is support
	 */
	boolean isProvideConformInfo_Customize (ItemStack stack);

	/**
	 * Is it possible to perform the modification.
	 *
	 * @param	stack	Stack to confirm.
	 * @param	modInfo	Modification type.
	 * @param	input	Input stacks of ForgeTable.
	 *
	 * @return	possible
	 */
	boolean isConform_Customize (ItemStack stack, ModConform modInfo, ItemStack[] input);
}
package ma.api.item;

import net.minecraft.item.ItemStack;

import java.util.ArrayList;

/**
 * incompletion interface...
 *
 * @author	licht
 */
@Deprecated
interface IDisassembableItem
{
	/**
	 * Check whether this item can be used as disassembable-item.
	 */
	boolean isDisassembable (ItemStack stack);

	/**
	 * @return	require tier
	 */
	int getDisassemblePowerRequire (ItemStack stack);

	/**
	 * @param result	obtained items by disassemble (not-null)
	 * @param stack		disassembled stack
	 */
	void onDisassemble (ArrayList<ItemStack> result, ItemStack stack);
}
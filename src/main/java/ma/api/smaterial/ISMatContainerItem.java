package ma.api.smaterial;

import net.minecraft.item.ItemStack;

/**
 * SMaterial-container interface for Item.
 *
 * @author	licht
 */
public interface ISMatContainerItem
{
	/**
	 * Fill hasMaterial to container.
	 *
	 * @param stack	Container item
	 * @param smat	Material that is poured
	 *
	 * @return		Amount of overflow
	 */
	int fillMaterial (ItemStack stack, SMatStack smat);

	/**
	 * Check whether it is possible to pour the hasMaterial.
	 *
	 * @param stack	Container item
	 * @param smat	Material that is poured
	 *
	 * @return		true(can) or false(can't)
	 */
	boolean canFillMaterial (ItemStack stack, SMatStack smat);

	/**
	 * Drain hasMaterial from container.
	 *
	 * @param stack		Container item
	 * @param maxDrain	Request amount
	 *
	 * @return			Pumped out hasMaterial
	 */
	SMatStack drainMaterial (ItemStack stack, int maxDrain);

	/**
	 * Drain hasMaterial from container.
	 * It is possible to specify the draft to container ID.
	 *
	 * @param stack		Container item
	 * @param maxDrain	Request amount
	 * @param container	Container ID
	 *
	 * @return			Pumped out hasMaterial
	 */
	SMatStack drainMaterial (ItemStack stack, int maxDrain, int container);

	/**
	 * Check whether it is possible sucked out from the container.
	 *
	 * @param stack	Container item
	 *
	 * @return		true(can) or false(can't)
	 */
	boolean canDrainMaterial (ItemStack stack);

	/**
	 * Check whether it is possible sucked out from the specified container.
	 *
	 * @param stack	Container item
	 *
	 * @return		true(can) or false(can't)
	 */
	boolean canDrainMaterial (ItemStack stack, int container);
}
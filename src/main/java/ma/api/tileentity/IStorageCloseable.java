package ma.api.tileentity;

import net.minecraft.inventory.IInventory;

/**
 * Interface for TileEntity.
 * Restrict access to the Item-slot.
 *
 * @author	licht
 */
public interface IStorageCloseable extends IInventory
{
	/**
	 * @param slotId	SlotID in Inventory
	 */
	boolean isClosedSlot (int slotId);
}
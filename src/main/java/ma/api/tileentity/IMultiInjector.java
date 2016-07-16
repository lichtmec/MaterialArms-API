package ma.api.tileentity;

import ma.api.smaterial.ISMatContainerTile;
import net.minecraft.inventory.IInventory;
import net.minecraftforge.common.util.ForgeDirection;

/**
 * Interface for TileEntity.
 * Accessed by Multi-block structure.
 *
 * @author	licht
 */
public interface IMultiInjector extends IInventory, ISMatContainerTile
{
	/**
	 * For ItemStacks
	 *
	 * @param dir	Direction for accessor
	 *
	 * @return	Injectable slot IDs (NonNull)
	 */
	int[] getSupplyingItem (ForgeDirection dir);

	/**
	 * For SMatStacks
	 *
	 * @param dir	Direction for accessor
	 *
	 * @return	Injectable slot IDs (NonNull)
	 */
	int[] getSupplyingMaterial (ForgeDirection dir);
}
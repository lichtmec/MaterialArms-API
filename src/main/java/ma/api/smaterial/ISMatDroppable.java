package ma.api.smaterial;

import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.List;

/**
 * Interface for SMaterial.<br>
 * Can be dropped as an item when a Block containing SMaterial is destroyed.
 *
 * @author	licht
 */
public interface ISMatDroppable
{
	/**
	 * @param smat	Target SMaterial stack
	 * @return	Drop item list.
	 */
	List<ItemStack> getDropOnContainerDestroyed (World world, int x, int y, int z, SMatStack smat);
}
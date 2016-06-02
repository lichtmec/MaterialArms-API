package ma.api.block;

import ma.api.item.IDisassembleTool;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

import java.util.ArrayList;

/**
 * @author	licht
 */
public interface IBlockDisassembable
{
	/**
	 * Check whether this item can be used as disassembable-item.
	 */
	boolean isDisassembable (Block block, World world, int x, int y, int z, IDisassembleTool.IDisassembleMethod disassembleMethod);

	/**
	 * @return	require tier
	 */
	int getDisassemblePowerRequire (Block block, World world, int x, int y, int z);

	/**
	 * @param result	obtained items by disassemble (not-null)
	 */
	void onDisassemble (ArrayList<ItemStack> result, Block block, World world, int x, int y, int z, IDisassembleTool.IDisassembleMethod disassembleMethod);
}
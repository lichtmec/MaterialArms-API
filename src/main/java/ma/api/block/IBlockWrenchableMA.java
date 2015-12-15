package ma.api.block;

import net.minecraft.entity.player.*;
import net.minecraft.item.*;
import net.minecraft.world.World;

/**
 * Handler when click with the wrench.
 * 
 * @author	licht
 */
public interface IBlockWrenchableMA
{
	/**
	 * called when clicked with a wrench.
	 * 
	 * @param 	stack		wrench stack
	 * @param 	player		player
	 * @param 	world		world
	 * @param 	x			block x
	 * @param 	y			block y
	 * @param 	z			block z
	 * @param 	side		clicked surface
	 * 
	 * @return	is consume durability
	 * 
	 * @author	licht
	 */
	public boolean onWrenchClick (ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side);
}
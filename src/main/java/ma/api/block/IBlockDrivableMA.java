package ma.api.block;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

/**
 * Handler when click with the screw-driver.
 * 
 * @author	licht
 */
public interface IBlockDrivableMA
{
	/**
	 * called when clicked with a screwdriver.
	 * 
	 * @param 	stack		screwdriver stack
	 * @param 	player		player
	 * @param 	world		world
	 * @param 	x			block x
	 * @param 	y			block y
	 * @param 	z			block z
	 * @param 	side		clicked surface
	 * 
	 * @return	is consume durability
	 */
	boolean onScrewdriverClick (ItemStack stack, EntityPlayer player, World world, int x, int y, int z, int side);
}
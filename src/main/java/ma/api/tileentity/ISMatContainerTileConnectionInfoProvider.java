package ma.api.tileentity;

import net.minecraftforge.common.util.ForgeDirection;

/**
 * Interface for TileEntity which implements ISMatContainerTile and checks the SMaterial type with canFill/canDrain.<br>
 * When this is implemented, PipeRenderer refers to this instead of ISMatContainerTile#canFill/canDrain.
 *
 * @author licht
 */
public interface ISMatContainerTileConnectionInfoProvider
{
	/**
	 * Can pipes be connected from dir?<br>
	 *
	 * @param dir connection from
	 * @return connectable
	 */
	boolean isSMatConnectable (ForgeDirection dir);
}
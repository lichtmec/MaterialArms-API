package ma.api.tileentity;

import net.minecraftforge.common.util.ForgeDirection;

/**
 * Electric TileEntity on MaterialArms
 * 
 * @author	licht
 */
public interface ITileElectric
{
	/**
	 * Return if it can connect with the surrounding ElectricTile.
	 * 
	 * @param	dir		direction on connect
	 * @return	can connect
	 */
	boolean isConnect (ForgeDirection dir);
	
	boolean isRequestMAEU ();
	
	long getChargeMAEU ();
	
	long getMaxChargeMAEU ();
	
	void connectMAEU (ITileElectric comparison);
	
	long chargeMAEU (long charge);
	
	long drainMAEU (long request);
}
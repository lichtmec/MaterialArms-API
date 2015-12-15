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
	 * 
	 * @author	licht
	 */
	public boolean isConnect (ForgeDirection dir);
	
	public boolean isRequestMAEU ();
	
	public long getChargeMAEU ();
	
	public long getMaxChargeMAEU ();
	
	public void connectMAEU (ITileElectric comparison);
	
	public long chargeMAEU (long charge);
	
	public long drainMAEU (long request);
}
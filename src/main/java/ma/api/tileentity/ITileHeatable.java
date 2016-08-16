package ma.api.tileentity;

import net.minecraftforge.common.util.ForgeDirection;

/**
 * Implement the concept of heat to TileEntity.<br>
 * Machines of MaterialArms release heat to the surrounding ITileHeatable.
 * 
 * @author	licht
 */
@Deprecated
public interface ITileHeatable
{
	/**
	 * Return the temperature of this TileEntity.
	 * 
	 * @return	Temperature of TileEntity (Kelvin)
	 */
	int getTemperature ();
	
	/**
	 * Heat this TileEntity.
	 * 
	 * @param	amount		Recieved heat
	 * @param	dir			Direction that receives
	 */
	void addHeat (int amount, ForgeDirection dir);
	
	/**
	 * Return the Heat-Conduction rate.<br>
	 * Actual heat conductivity is determined by the multiplication of sender and receiver side.
	 * 
	 * @param	dir			Direction in contact
	 */
	float getHeatConductionRate (ForgeDirection dir);
}
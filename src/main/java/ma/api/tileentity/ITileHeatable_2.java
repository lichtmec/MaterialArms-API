package ma.api.tileentity;

/**
 * Implement the concept of heat to TileEntity.<br>
 * Machines of MaterialArms release heat to the surrounding ITileHeatable.
 *
 * @author	licht
 */
public interface ITileHeatable_2 extends ITileHeatable
{
	/**
	 * @return	int value(set by ITileHeatable_2#setAcceptedHeatBuffer)
	 */
	int getAcceptedHeatBuffer ();

	/**
	 * @param amount	new buffer-param
	 */
	void setAcceptedHeatBuffer (int amount);
}
package ma.api.tileentity;

import net.minecraftforge.common.util.ForgeDirection;

/**
 * ElectricTile supporting to direction.<br>
 * [Recommend] If 'dir' equals UNKNOWN, behaves the same as ITileElectric.<br>
 * <br>
 * Tarnsmitter :<br>
 *     Consider that the destination implements this interface.<br>
 *     ( Transmitter classes do not need to implement this interface. )<br>
 * <br>
 * Receiver :<br>
 *     Implement this interface if want to support 'direction'.
 *
 * @author licht
 */
public interface ITileElectricDirectional extends ITileElectric
{
	boolean isRequestMAEU (ForgeDirection dir);

	long getChargeMAEU (ForgeDirection dir);

	long getMaxChargeMAEU (ForgeDirection dir);

	void connectMAEU (ITileElectric comparison, ForgeDirection dir);

	long chargeMAEU (long charge, ForgeDirection dir);

	long drainMAEU (long request, ForgeDirection dir);
}
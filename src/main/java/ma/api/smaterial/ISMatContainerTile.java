package ma.api.smaterial;

import net.minecraftforge.common.util.ForgeDirection;

/**
 * SMaterial-container interface for TileEntity.
 *
 * @author licht
 */
public interface ISMatContainerTile extends ISMatContainer
{
	/**
	 * Fill material to container.
	 *
	 * @param dir	Inject direction
	 * @param smat	Material that is poured
	 *
	 * @return		Amount of overflow
	 */
	int fillMaterial (ForgeDirection dir, SMatStack smat);

	/**
	 * Check whether it is possible to pour the material.
	 *
	 * @param dir	Inject direction
	 * @param smat	Material that is poured
	 *
	 * @return		true(can) or false(can't)
	 */
	boolean canFillMaterial (ForgeDirection dir, SMatStack smat);

	/**
	 * Drain material from container.
	 *
	 * @param dir		Drain direction
	 * @param maxDrain	Request amount
	 *
	 * @return			Pumped out material
	 */
	SMatStack drainMaterial (ForgeDirection dir, int maxDrain);

	/**
	 * Drain material from container.<br>
	 * It is possible to specify the draft to container ID.
	 *
	 * @param dir		Drain direction
	 * @param maxDrain	Request amount
	 * @param container	Target container ID
	 *
	 * @return			Pumped out material
	 */
	SMatStack drainMaterial (ForgeDirection dir, int maxDrain, int container);

	/**
	 * Check whether it is possible sucked to from the direction.
	 *
	 * @param dir	Drain direction.
	 *
	 * @return	true(can) or false(can't)
	 */
	boolean canDrainMaterial (ForgeDirection dir);

	/**
	 * Check whether it is possible sucked out from the container in that direction.
	 *
	 * @param dir		Drain direction
	 * @param container	Container ID
	 *
	 * @return	true(can) or false(can't)
	 */
	boolean canDrainMaterial (ForgeDirection dir, int container);
}
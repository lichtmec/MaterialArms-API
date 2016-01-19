package ma.api.smaterial;

import net.minecraftforge.common.util.ForgeDirection;

public interface ISMatContainerTile extends ISMatContainer
{
	int fillMaterial (ForgeDirection dir, SMatStack smat);

	boolean canFillMaterial (ForgeDirection dir, SMatStack smat);

	SMatStack drainMaterial (ForgeDirection dir, int maxDrain);

	SMatStack drainMaterial (ForgeDirection dir, int maxDrain, int container);

	boolean canDrainMaterial (ForgeDirection dir);

	boolean canDrainMaterial (ForgeDirection dir, int container);
}
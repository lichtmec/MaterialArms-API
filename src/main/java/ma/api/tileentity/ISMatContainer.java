package ma.api.tileentity;

import net.minecraftforge.common.util.ForgeDirection;

import ma.common.smaterial.*;

public interface ISMatContainer
{
	SMatStack getMaterialContainer (int container);
	
	int getMaterialAmout (int container);
	
	int getMaterialContainerSize ();
	
	int getMaterialContainerCapacity (int container);
	
	SMatContainerInfo getMaterialContainerInfo (int container);
	
	int fillMaterial (ForgeDirection dir, SMatStack smat);
	
	boolean canFillMaterial (ForgeDirection dir, SMatStack smat);
	
	SMatStack drainMaterial (ForgeDirection dir, int maxDrain);
	
	SMatStack drainMaterial (ForgeDirection dir, int maxDrain, int container);
	
	boolean canDrainMaterial (ForgeDirection dir, SMatStack smat);
	
	class SMatContainerInfo
	{
		public SMatStack smat;
		public int capacity;
		
		public SMatContainerInfo (SMatStack smat, int capacity)
		{
			this.smat = smat;
			this.capacity = capacity;
		}
	}
}
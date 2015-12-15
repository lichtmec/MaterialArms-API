package ma.api.tileentity;

import net.minecraftforge.common.util.ForgeDirection;

import ma.common.smaterial.*;

public interface ISMatContainer
{
	public SMatStack getMaterialContainer (int container);
	
	public int getMaterialAmout (int container);
	
	public int getMaterialContainerSize ();
	
	public int getMaterialContainerCapacity (int container);
	
	public SMatContainerInfo getMaterialContainerInfo (int container);
	
	public int fillMaterial (ForgeDirection dir, SMatStack smat);
	
	public boolean canFillMaterial (ForgeDirection dir, SMatStack smat);
	
	public SMatStack drainMaterial (ForgeDirection dir, int maxDrain);
	
	public SMatStack drainMaterial (ForgeDirection dir, int maxDrain, int container);
	
	public boolean canDrainMaterial (ForgeDirection dir, SMatStack smat);
	
	public static class SMatContainerInfo
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
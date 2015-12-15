package ma.api.tileentity;

import net.minecraft.tileentity.TileEntity;

public class MATileCommonProcess
{
	public static ITileCommonProcess commonProcess;
	
	public static void doAllProcess (TileEntity tile)
	{
		onUpdateContainer((ISMatContainer)tile);
		
		releaseHeatToBlock((ITileHeatable)tile);
		releaseHeatToAir((ITileHeatable)tile);
	}
	
	public static void onUpdateContainer (ISMatContainer tile)
	{
		commonProcess.onUpdateContainer(tile);
	}
	
	public static void releaseHeatToBlock (ITileHeatable tile)
	{
		commonProcess.releaseHeatToBlock(tile);
	}
	
	public static void releaseHeatToAir (ITileHeatable tile)
	{
		commonProcess.releaseHeatToAir(tile);
	}
	
	public static interface ITileCommonProcess
	{
		public float HEAT_CONDUCTION_RATE_AIR = 0.1F;
		
		public void onUpdateContainer (ISMatContainer tile);
		
		public void releaseHeatToBlock (ITileHeatable tile);
		
		public void releaseHeatToAir (ITileHeatable tile);
	}
}
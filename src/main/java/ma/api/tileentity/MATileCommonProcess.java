package ma.api.tileentity;

import ma.api.smaterial.ISMatContainer;
import net.minecraft.tileentity.TileEntity;

public class MATileCommonProcess
{
	private static ITileCommonProcess commonProcess;
	
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

	@Deprecated
	public static void releaseHeatToBlock (ITileHeatable tile)
	{
		commonProcess.releaseHeatToBlock(tile);
	}

	@Deprecated
	public static void releaseHeatToAir (ITileHeatable tile)
	{
		commonProcess.releaseHeatToAir(tile);
	}
	
	public interface ITileCommonProcess
	{
		float HEAT_CONDUCTION_RATE_AIR = 0.02F;
		
		void onUpdateContainer (ISMatContainer tile);
		
		void releaseHeatToBlock (ITileHeatable tile);
		
		void releaseHeatToAir (ITileHeatable tile);
	}
}
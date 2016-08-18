package ma.api.block;

import net.minecraft.block.Block;
import net.minecraft.world.World;

/**
 * GeothermalHeater Source Register and Source Item interface.
 *
 * @author	licht
 */
public class GeothermalHeaterSource
{
	private static IGeothermalHeaterSourceRegister register;

	public static void registerSource (IGeothermalHeaterSource source)
	{
		register.registerSource(source);
	}

	/**
	 * GeothermalHeater Source.
	 *
	 * @author	licht
	 */
	public static interface IGeothermalHeaterSource
	{
		/**
		 * @return	that is source.
		 */
		boolean isMatch (World world, int xPos, int yPos, int zPos);

		/**
		 * @return	source temperature
		 */
		int getTemperature (World world, int xPos, int yPos, int zPos);

		/**
		 * @return	conduction rate (Top)
		 */
		float getHeatConductionRate (World world, int xPos, int yPos, int zPos);
	}

	public static class GeothermalHeaterSourceBlock implements IGeothermalHeaterSource
	{
		private final Block block;
		private final int metadata;

		private final int temp;
		private final float conduction;

		public GeothermalHeaterSourceBlock (Block block, int meta, int temp, float heatConduction)
		{
			this.block = block;
			this.metadata = meta;

			this.temp = temp;
			this.conduction = heatConduction;
		}

		@Override
		public boolean isMatch (World world, int xPos, int yPos, int zPos)
		{
			return (this.block == world.getBlock(xPos, yPos, zPos)) && (this.metadata == world.getBlockMetadata(xPos, yPos, zPos));
		}

		@Override
		public int getTemperature (World world, int xPos, int yPos, int zPos)
		{
			return this.temp;
		}

		@Override
		public float getHeatConductionRate (World world, int xPos, int yPos, int zPos)
		{
			return this.conduction;
		}
	}

	public static interface IGeothermalHeaterSourceRegister
	{
		void registerSource (IGeothermalHeaterSource source);
	}
}
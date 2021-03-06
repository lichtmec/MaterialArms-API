package ma.api.smaterial;

import java.util.*;

import net.minecraft.nbt.*;
import net.minecraft.tileentity.*;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fluids.*;

/**
 * Define of SMaterial.
 *
 * @author	licht
 */
public class SMaterial
{
	String name;
	int defaultTemp = 295;
	int color = 0xFFFFFF;
	
	public static final int AMOUNT_PAR_INGOT = 144;
	
	public static final int TEMP_UNDEFINED = -1;
	int meltingTemp = TEMP_UNDEFINED;
	int boilingTemp = TEMP_UNDEFINED;
	int plasmaTemp = TEMP_UNDEFINED;

	private final List<String> correspondingFluidNameList = new ArrayList<>();
	
	public SMaterial ()
	{
		this.name = "unnamed";
		
		onInit();
	}
	
	public SMaterial (String name)
	{
		this.name = name;
		
		onInit();
	}
	
	public void onInit ()
	{
	}

	/**
	 * @return	Material name, used by registered name
	 */
	public String getMaterialName ()
	{
		return name;
	}
	
	public int getDefaultTemp ()
	{
		return defaultTemp;
	}
	
	public int getMeltingTemp ()
	{
		return this.meltingTemp;
	}
	
	public int getBoilingTemp ()
	{
		return this.boilingTemp;
	}
	
	public int getPlasmaTemp ()
	{
		return this.plasmaTemp;
	}
	
	public SMaterial setDefaultTemp (int temp)
	{
		this.defaultTemp = temp;
		
		return this;
	}
	
	public SMaterial setStateTemp (int melting, int boiling)
	{
		setStateTemp(melting, boiling, TEMP_UNDEFINED);
		
		return this;
	}
	
	public SMaterial setStateTemp (int melting, int boiling, int plasma)
	{
		this.meltingTemp = melting;
		this.boilingTemp = boiling;
		this.plasmaTemp = plasma;
		
		return this;
	}
	
	public int getColor ()
	{
		return this.color;
	}
	
	public SMaterial setColor (int color)
	{
		this.color = color;
		
		return this;
	}
	
	public int getColor (SMatStack smat)
	{
		return getColor();
	}
	
	public void addInformation (SMatStack smat, List list)
	{
		list.add(StatCollector.translateToLocal("gui.smatcontainer.temp").replaceAll("&#", "") + ": " + smat.temp + "K");
		list.add(StatCollector.translateToLocal("gui.smatcontainer.state").replaceAll("&#", "") + ": " + getState(smat).getUnlocalizeStateName());
	}
	
	public void onTileUpdate (TileEntity tile, SMatStack smat)
	{
		if (smat.isDust && this.getState(smat) != States.DUST)
		{
			smat.setIsDust(false);
		}
	}
	
	public void readFromNBT (NBTTagCompound nbt, SMatStack smat)
	{
	}
	
	public void writeToNBT (NBTTagCompound nbt, SMatStack smat)
	{
	}

	@Deprecated
	public FluidStack[] toForgeFluid (SMatStack smat)
	{
		return null;
	}
	
	public String getDisplayName (SMatStack smat)
	{
		return StatCollector.translateToLocal(getUnlocalizedName());
	}
	
	public String getUnlocalizedName ()
	{
		return "statablematerial." + getMaterialName() + ".name";
	}
	
	public States getState (SMatStack smat)
	{
		if (this.meltingTemp != TEMP_UNDEFINED)
		{
			if (this.meltingTemp * 0.8 > smat.temp)
			{
				if (smat.isDust)
				{
					return States.DUST;
				}
				else
				{
					return States.SOLID;
				}
			}
			else if (this.boilingTemp != TEMP_UNDEFINED)
			{
				if (this.boilingTemp > smat.temp)
				{
					return States.LIQUID;
				}
				else
				{
					return States.GAS;
				}
			}
		}
		
		if (this.plasmaTemp != TEMP_UNDEFINED)
		{
			if (this.plasmaTemp <= smat.temp)
			{
				return States.PLASMA;
			}
		}
		
		return States.UNKNOWN;
	}

	public boolean addCorrespondingFluidName (String name)
	{
		boolean ret = false;

		if (!this.correspondingFluidNameList.contains(name))
		{
			this.correspondingFluidNameList.add(name);
			ret = true;
		}

		return ret;
	}

	public List<String> getCorrespondingFluidNameList ()
	{
		return this.correspondingFluidNameList;
	}

	public SMaterial mixWith (SMaterial mixMaterial)
	{
		return (this == mixMaterial) ? this : SMatRegistryAccess.getMaterial("_S-MATERIAL_");
	}
	
	public enum States
	{
		SOLID(false),
		DUST(true),
		LIQUID(true),
		GAS(true),
		PLASMA(true),
		UNKNOWN(false);
		
		private final boolean isFluid;
		
		States (boolean isFluid)
		{
			this.isFluid = isFluid;
		}
		
		public boolean isFluid ()
		{
			return this.isFluid;
		}

		public String getUnlocalizeStateName ()
		{
			return StatCollector.translateToLocal("statablematerial.state." + this.toString());
		}
	}
}
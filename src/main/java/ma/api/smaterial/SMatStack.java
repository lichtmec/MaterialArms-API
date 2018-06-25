package ma.api.smaterial;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.nbt.*;

/**
 * @see net.minecraft.item.ItemStack
 *
 * @author	licht
 */
public final class SMatStack
{
	public SMaterial material;
	public int amount;
	public int temp;
	public float compression;
	public boolean isDust;
	public NBTTagCompound nbt, nbt_ex;
	
	public SMatStack (SMaterial fluid, int amount)
	{
		this(fluid, amount, fluid.getDefaultTemp());
	}
	
	public SMatStack (SMaterial material, int amount, int temp)
	{
		this(material, amount, temp, 1F);
	}

	public SMatStack (SMaterial material, int amount, int temp, float compression)
	{
		this.material = material;
		this.amount = amount;
		this.temp = temp;
		this.compression = compression;
		this.isDust = false;
	}
	
	public SMatStack (SMaterial material, int amount, NBTTagCompound nbt)
	{
		this(material, amount);
		
		if (this.nbt != null)
		{
			this.nbt = (NBTTagCompound)nbt.copy();
		}
	}
	
	public SMatStack (SMaterial material, int amount, NBTTagCompound nbt, int temp)
	{
		this(material, amount, temp);
		
		if (this.nbt != null)
		{
			this.nbt = (NBTTagCompound)nbt.copy();
		}
	}
	
	public static SMatStack loadSMatStackFromNBT (NBTTagCompound nbt)
	{
		if (nbt == null)
		{
			return null;
		}
		
		String name = nbt.getString("smat.name");
		int amount = nbt.getInteger("smat.amount");
		int temp = nbt.getInteger("smat.temp");
		float compress = nbt.getFloat("smat.compress");
		boolean isDust = nbt.getBoolean("smat.bdust");

		SMaterial material = SMatRegistryAccess.getMaterial(name);
		SMatStack materialStack;
		if (material != null)
		{
			materialStack = (new SMatStack(material, amount, temp, compress));
			materialStack.setIsDust(isDust);

			if (nbt.hasKey("smat.tag"))
			{
				materialStack.nbt = nbt.getCompoundTag("smat.tag");
			}

			materialStack.material.readFromNBT(materialStack.nbt_ex, materialStack);
		}
		else
		{
			materialStack = null;
		}
		
		return materialStack;
	}
	
	public void writeToNBT (NBTTagCompound nbt)
	{
		nbt.setString("smat.name", material.getMaterialName());
		nbt.setInteger("smat.amount", this.amount);
		nbt.setInteger("smat.temp", this.temp);
		nbt.setFloat("smat.compress", this.compression);
		nbt.setBoolean("smat.bdust", this.isDust);
		
		if (this.nbt != null)
		{
			nbt.setTag("smat.tag", this.nbt);
		}
		
		this.material.writeToNBT(nbt_ex, this);
	}
	
	public SMaterial getMaterial ()
	{
		return this.material;
	}
	
	public String getDisplayName ()
	{
		return this.material.getDisplayName(this);
	}
	
	public String getUnlocalizedName ()
	{
		return this.material.getUnlocalizedName();
	}

	public SMatStack setTemperature (int temp)
	{
		if (temp >= 0)
		{
			this.temp = temp;
		}

		return this;
	}

	public SMatStack setCompression (float compression)
	{
		if (compression > 0F)
		{
			this.compression = compression;
		}

		return this;
	}

	public SMatStack setIsDust (boolean isDust)
	{
		this.isDust = isDust;

		return this;
	}
	
	public SMatStack copy ()
	{
		return (new SMatStack(this.material, this.amount, this.nbt, this.temp)).setCompression(this.compression).setIsDust(this.isDust);
	}
	
	public List getHoveringText ()
	{
		List list = new ArrayList();
		
		list.add(getDisplayName());
		this.material.addInformation(this, list);
		
		return list;
	}
	
	public SMaterial.States getState ()
	{
		return this.material.getState(this);
	}
	
	public static SMatStack mix (SMatStack smStack0, SMatStack smStack1)
	{
		if (smStack0 == null && smStack1 == null)		return null;
		if (smStack0 == null || smStack0.amount <= 0)	return smStack1.copy();
		if (smStack1 == null || smStack1.amount <= 0)	return smStack0.copy();

		SMaterial mixedMaterial = smStack0.getMaterial().mixWith(smStack1.getMaterial());
		int temp = (smStack0.temp * smStack0.amount + smStack1.temp * smStack1.amount) / (smStack0.amount + smStack1.amount);
		float compression = (smStack0.amount * smStack0.compression + smStack1.amount * smStack1.compression) / (smStack0.amount + smStack1.amount);
		int amount = Math.round((smStack0.amount * smStack0.compression + smStack1.amount * smStack1.compression) / compression);

		SMatStack ret = new SMatStack(mixedMaterial, amount, temp, compression);
		ret.setIsDust(smStack0.isDust && smStack1.isDust);

		return ret;
	}
}
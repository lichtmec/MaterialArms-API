package ma.api.smaterial;

import java.util.*;

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
		
		SMatStack material = new SMatStack(SMatRegistryAccess.getMaterial(name), amount, temp);
		
		if (nbt.hasKey("smat.tag"))
		{
			material.nbt = nbt.getCompoundTag("smat.tag");
		}
		
		material.material.readFromNBT(material.nbt_ex, material);
		
		return material;
	}
	
	public void writeToNBT (NBTTagCompound nbt)
	{
		nbt.setString("smat.name", material.getMaterialName());
		nbt.setInteger("smat.amount", this.amount);
		nbt.setInteger("smat.temp", this.temp);
		
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
	
	public SMatStack copy ()
	{
		return new SMatStack(this.material, this.amount, this.nbt, this.temp);
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
		if (smStack0 == null || smStack0.amount <= 0)	return smStack1;
		if (smStack1 == null || smStack1.amount <= 0)	return smStack0;
		
		SMatStack ret = new SMatStack(null, smStack0.amount + smStack1.amount, 0);
		
		if (smStack0.getMaterial() != smStack1.getMaterial())
		{
			ret.material = SMatRegistryAccess.getMaterial("_S-MATERIAL_");
		}
		else
		{
			ret.material = smStack0.material;
		}
		
		ret.temp = (smStack0.temp * smStack0.amount + smStack1.temp * smStack1.amount) / (smStack0.amount + smStack1.amount);
		
		return ret;
	}
}